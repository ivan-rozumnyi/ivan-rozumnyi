import unittest
from recursive_json_search import json_search
from test_data import key1, key2, data


class json_search_test(unittest.TestCase):
    """Tests for recursive_json_search.json_search()."""

    def test_search_found(self):
        """key should be found, return list should not be empty"""
        self.assertTrue([] != json_search(key1, data))

    def test_search_not_found(self):
        """key should not be found, should return an empty list"""
        self.assertTrue([] == json_search(key2, data))

    def test_is_a_list(self):
        """Should return a list"""
        self.assertIsInstance(json_search(key1, data), list)


if __name__ == '__main__':
    unittest.main()
