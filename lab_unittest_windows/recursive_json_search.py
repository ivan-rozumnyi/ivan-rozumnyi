from test_data import *

def json_search(key, input_object):
    """
    Search a key from a JSON-like object.
    Return a list of key:value pairs if the key is found.
    """
    ret_val = []

    def inner_function(key, input_object):
        if isinstance(input_object, dict):
            for k, v in input_object.items():
                if k == key:
                    temp = {k: v}
                    ret_val.append(temp)

                if isinstance(v, dict):
                    inner_function(key, v)
                elif isinstance(v, list):
                    for item in v:
                        if not isinstance(item, (str, int)):
                            inner_function(key, item)
        else:
            for val in input_object:
                if not isinstance(val, (str, int)):
                    inner_function(key, val)

    inner_function(key, input_object)
    return ret_val

if __name__ == "__main__":
    print(json_search("issueSummary", data))
