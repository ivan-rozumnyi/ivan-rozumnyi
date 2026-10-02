#!/bin/bash
set -e

rm -rf tempdir
mkdir -p tempdir/templates
mkdir -p tempdir/static
cp sample_app.py tempdir/.
cp -r templates/* tempdir/templates/.
cp -r static/* tempdir/static/.

echo "FROM python:3.12-slim" >> tempdir/Dockerfile
echo "RUN pip install --no-cache-dir flask" >> tempdir/Dockerfile
echo "COPY ./static /home/myapp/static/" >> tempdir/Dockerfile
echo "COPY ./templates /home/myapp/templates/" >> tempdir/Dockerfile
echo "COPY sample_app.py /home/myapp/" >> tempdir/Dockerfile
echo "EXPOSE 5050" >> tempdir/Dockerfile
echo "CMD python3 /home/myapp/sample_app.py" >> tempdir/Dockerfile

cd tempdir
docker build -t sampleapp .
docker rm -f samplerunning 2>/dev/null || true
docker run -t -d -p 5050:5050 --name samplerunning sampleapp
docker ps -a
