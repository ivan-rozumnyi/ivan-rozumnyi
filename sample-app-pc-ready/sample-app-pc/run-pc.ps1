$ErrorActionPreference = "Stop"

if (Test-Path .\tempdir) { Remove-Item .\tempdir -Recurse -Force }
New-Item -ItemType Directory .\tempdir\templates | Out-Null
New-Item -ItemType Directory .\tempdir\static | Out-Null

Copy-Item .\sample_app.py .\tempdir\
Copy-Item .\templates\* .\tempdir\templates\ -Recurse
Copy-Item .\static\* .\tempdir\static\ -Recurse

@"
FROM python
RUN pip install flask
COPY ./static /home/myapp/static/
COPY ./templates /home/myapp/templates/
COPY sample_app.py /home/myapp/
EXPOSE 8080
CMD python3 /home/myapp/sample_app.py
"@ | Set-Content .\tempdir\Dockerfile -Encoding ascii

Set-Location .\tempdir
docker build -t sampleapp .
docker rm -f samplerunning 2>$null
if ($LASTEXITCODE -ne 0) { $LASTEXITCODE = 0 }
docker run -t -d -p 8080:8080 --name samplerunning sampleapp
docker ps -a
