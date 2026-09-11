import unittest
from recursive_json_search_bug1 import json_search
from test_data import key1, key2, data

class json_search_test(unittest.TestCase):
    def test_search_found(self):
        self.assertTrue([] != json_search(key1, data))

    def test_search_not_found(self):
        self.assertTrue([] == json_search(key2, data))

    def test_is_a_list(self):
        self.assertIsInstance(json_search(key1, data), list)

if __name__ == '__main__':
    unittest.main()
