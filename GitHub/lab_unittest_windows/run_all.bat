@echo off
chcp 65001 >nul
echo
echo
echo
echo.
echo
python --version
echo.
echo
python recursive_json_search_bug1.py
echo.
echo
python -m unittest -v initial_json_search_test.py
echo.
echo
python recursive_json_search.py
echo.
echo
python -m unittest -v
echo.
echo
pause
