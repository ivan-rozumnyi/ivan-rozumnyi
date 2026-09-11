@echo off
chcp 65001 >nul
echo
echo
echo
echo
echo.
echo
python --version
echo.
echo
python parsexml.py
echo.
echo
python parsejson.py
echo.
echo
python parseyaml.py
echo.
echo
pause
