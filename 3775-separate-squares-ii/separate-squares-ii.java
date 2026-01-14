import java.util.*;

class Solution {

    static class Event {
        double y;
        int x1, x2;
        int type; // +1 add, -1 remove

        Event(double y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegTree {
        int n;
        int[] count;
        double[] length;
        double[] xs;

        SegTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new double[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        double query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        int n = squares.length;
        List<Double> xsList = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];

            xsList.add(x1);
            xsList.add(x2);

            events.add(new Event(y1, 0, 0, +1));
            events.add(new Event(y2, 0, 0, -1));
        }

        // Coordinate compression
        Collections.sort(xsList);
        double[] xs = xsList.stream().distinct().mapToDouble(d -> d).toArray();

        Map<Double, Integer> index = new HashMap<>();
        for (int i = 0; i < xs.length; i++) index.put(xs[i], i);

        int e = 0;
        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];

            events.set(e++, new Event(y1, index.get(x1), index.get(x2), +1));
            events.set(e++, new Event(y2, index.get(x1), index.get(x2), -1));
        }

        events.sort(Comparator.comparingDouble(ev -> ev.y));

        SegTree st = new SegTree(xs);

        // First pass: total area
        double totalArea = 0;
        double prevY = events.get(0).y;

        for (Event ev : events) {
            double curY = ev.y;
            totalArea += st.query() * (curY - prevY);
            st.update(ev.x1, ev.x2, ev.type);
            prevY = curY;
        }

        double half = totalArea / 2.0;

        // Second pass: find minimum y
        st = new SegTree(xs);
        prevY = events.get(0).y;
        double acc = 0;

        for (Event ev : events) {
            double curY = ev.y;
            double width = st.query();
            double slab = width * (curY - prevY);

            if (acc + slab >= half) {
                return prevY + (half - acc) / width;
            }

            acc += slab;
            st.update(ev.x1, ev.x2, ev.type);
            prevY = curY;
        }

        return prevY;
    }
}
