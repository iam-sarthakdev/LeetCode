#pragma GCC optimize("Ofast,unroll-loops")

using IntArr = std::vector<int>;
using IntMtx = std::vector<IntArr>;
using u32 = std::uint32_t;

constexpr int symb_cnt(int x) {
  int ans = 0;
  if(x < 0) { x = -x; ++ans; }
  return ans +
    (
      x < 10ULL ? 1 :
      x < 100ULL ? 2 :
      x < 1'000ULL ? 3 :
      x < 10'000ULL ? 4 :
      x < 100'000ULL ? 5 :
      x < 1'000'000ULL ? 6 :
      x < 10'000'000ULL ? 7 :
      x < 100'000'000ULL ? 8 :
      x < 1'000'000'000ULL ? 9 :
      10
    );
}

class Solution final {
public:
  IntArr findColumnWidth(const IntMtx& g) const {
    IntArr ans(g.front().size(), -1);
    for(const auto& r : g)
      for(int c = 0; const auto x : r)
        { ans[c] = std::max(ans[c], symb_cnt(x)); ++c; }
    return ans;
  }
};