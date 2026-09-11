# DEVASC Git Lab — PowerShell version
# Run in PowerShell from the folder where you want the lab to live.
# Requires Git for Windows.

$ErrorActionPreference = "Stop"

$root = Join-Path $HOME "devasc-git-lab"
New-Item -ItemType Directory -Force -Path $root | Out-Null
Set-Location $root

# Part 2: initialize Git
git config --global user.name "YOUR NAME"
git config --global user.email "YOUR_EMAIL@example.com"

$repo = Join-Path $root "git-intro"
New-Item -ItemType Directory -Force -Path $repo | Out-Null
Set-Location $repo
git init

# Part 3: create and commit DEVASC.txt
Set-Content -Path "DEVASC.txt" -Value "I am on my way to passing the Cisco DEVASC exam" -Encoding utf8
git add DEVASC.txt
git commit -m "Committing DEVASC.txt to begin tracking changes"

# Part 4: modify and commit
Add-Content -Path "DEVASC.txt" -Value "I am beginning to understand Git!" -Encoding utf8
git add DEVASC.txt
git commit -m "Added additional line to file"

# Part 5: feature branch and merge
git branch feature
git checkout feature
Add-Content -Path "DEVASC.txt" -Value "This text was added originally while in the feature branch" -Encoding utf8
git add DEVASC.txt
git commit -m "Added a third line in feature branch"
git checkout master
git merge feature
git branch -d feature

# Part 6: merge conflict
git branch test
git checkout test
(Get-Content DEVASC.txt -Raw) -replace "Cisco","NetAcad" | Set-Content DEVASC.txt -Encoding utf8
git commit -a -m "Change Cisco to NetAcad"

git checkout master
(Get-Content DEVASC.txt -Raw) -replace "Cisco","DevNet" | Set-Content DEVASC.txt -Encoding utf8
git commit -a -m "Changed Cisco to DevNet"

# Intentionally create the merge conflict
git merge test
# Resolve by keeping DevNet on the first line:
@(
  "I am on my way to passing the DevNet DEVASC exam"
  "I am beginning to understand Git!"
  "This text was added originally while in the feature branch"
) | Set-Content DEVASC.txt -Encoding utf8

git add DEVASC.txt
git commit -a -m "Manually merged from test branch"

Write-Host "`n=== FINAL STATUS ==="
git status
Write-Host "`n=== FINAL LOG ==="
git --no-pager log --oneline --decorate --all
Write-Host "`n=== FINAL FILE ==="
Get-Content DEVASC.txt

# Part 7: prepare GitHub repository locally
$team = Join-Path $repo "devasc-study-team"
New-Item -ItemType Directory -Force -Path $team | Out-Null
Copy-Item (Join-Path $repo "DEVASC.txt") (Join-Path $team "DEVASC.txt") -Force
Set-Location $team
git init
git remote add origin "https://github.com/GITHUB_USERNAME/devasc-study-team.git"
git add DEVASC.txt
git commit -m "Add DEVASC.txt file to devasc-study-team"

Write-Host "`nGitHub remote configured as:"
git remote -v
Write-Host "`nWhen your GitHub repository exists, push with:"
Write-Host "git push -u origin master"
Write-Host "Use your GitHub username and a Personal Access Token if prompted."
