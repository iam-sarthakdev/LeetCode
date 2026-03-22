import pandas as pd

def find_valid_emails(users: pd.DataFrame) -> pd.DataFrame:

    def is_valid(x: str)-> bool:

        s = x.email.split('@')
        if len(s) != 2: return False           # check for exactly one '@'

        pref, suff = s                         # check whether underscore is the
        pref.replace('_', '')                  # only non-alpha in prefix
                             
        return all( (pref.isalnum(),             # check whether prefix is alphanumeric
                     suff[:-4].isalpha(),      # check whether suffix starts with alpha
                     suff.endswith('.com')) )  # check whether suffix ends with '.com'

    return users[users.apply(is_valid, axis=1)].sort_values(['user_id'])