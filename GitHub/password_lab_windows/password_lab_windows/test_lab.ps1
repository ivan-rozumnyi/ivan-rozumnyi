$ErrorActionPreference = 'Stop'
$baseUrl = 'http://127.0.0.1:5000'

try {
    Invoke-WebRequest -Uri "$baseUrl/" -TimeoutSec 3 | Out-Null
} catch {
    Write-Host 'ERROR: Server is not running.' -ForegroundColor Red
    Write-Host 'First run setup_and_run.bat and leave its window open.'
    exit 1
}

function Send-Form {
    param(
        [Parameter(Mandatory=$true)][string]$Path,
        [Parameter(Mandatory=$true)][hashtable]$Fields
    )
    return Invoke-RestMethod -Uri "$baseUrl$Path" -Method Post -Body $Fields
}

$tag = Get-Date -Format 'yyyyMMddHHmmss'
$alice = "alice_$tag"
$bob = "bob_$tag"
$rick = "rick_$tag"
$allan = "allan_$tag"
$dave = "dave_$tag"

Write-Host "`n=== Part 4: plaintext passwords ===" -ForegroundColor Cyan
Write-Host "signup $alice : $(Send-Form '/signup/v1' @{ username=$alice; password='myalicepassword' })"
Write-Host "signup $bob : $(Send-Form '/signup/v1' @{ username=$bob; password='passwordforbob' })"
Write-Host "login $alice : $(Send-Form '/login/v1' @{ username=$alice; password='myalicepassword' })"
Write-Host "login $bob : $(Send-Form '/login/v1' @{ username=$bob; password='passwordforbob' })"

Write-Host "`n=== Part 5: SHA-256 password hashes ===" -ForegroundColor Cyan
Write-Host "signup $rick : $(Send-Form '/signup/v2' @{ username=$rick; password='samepassword' })"
Write-Host "signup $allan : $(Send-Form '/signup/v2' @{ username=$allan; password='samepassword' })"
Write-Host "signup $dave : $(Send-Form '/signup/v2' @{ username=$dave; password='differentpassword' })"
Write-Host "login $rick (correct password) : $(Send-Form '/login/v2' @{ username=$rick; password='samepassword' })"
Write-Host "login $allan (wrong password) : $(Send-Form '/login/v2' @{ username=$allan; password='wrongpassword' })"
Write-Host "login $allan (correct password) : $(Send-Form '/login/v2' @{ username=$allan; password='samepassword' })"
Write-Host "login $dave (correct password) : $(Send-Form '/login/v2' @{ username=$dave; password='differentpassword' })"

Write-Host "`nTests complete. Database usernames use suffix $tag." -ForegroundColor Green
Write-Host 'To inspect stored values, run: .\.venv\Scripts\python.exe view_database.py'
