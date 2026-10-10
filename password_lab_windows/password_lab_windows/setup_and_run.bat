@echo off
setlocal
cd /d "%~dp0"

echo
echo
echo

if not exist ".venv\Scripts\python.exe" (
    echo Creating a small Python package environment (not a virtual machine)...
    where py >nul 2>&1
    if not errorlevel 1 (
        py -3 -m venv .venv
    ) else (
        python -m venv .venv
    )
    if errorlevel 1 goto :error
)

echo Installing required Python packages...
".venv\Scripts\python.exe" -m pip install --upgrade pip
if errorlevel 1 goto :error
".venv\Scripts\python.exe" -m pip install -r requirements.txt
if errorlevel 1 goto :error

echo.
echo Starting the lab service at http://127.0.0.1:5000/
echo Keep this window open. Press Ctrl+C here to stop the server.
echo.
".venv\Scripts\python.exe" password-evolution.py
if errorlevel 1 goto :error
pause
exit /b 0

:error
echo.
echo Setup failed. Check that Python 3 is installed and available as py or python.
pause
exit /b 1
