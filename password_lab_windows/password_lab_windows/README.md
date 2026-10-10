powershell

Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass

.\test_lab.ps1

.\.venv\Scripts\python.exe view_database.py
