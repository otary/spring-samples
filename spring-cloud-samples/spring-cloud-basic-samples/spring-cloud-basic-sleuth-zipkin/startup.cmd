@echo off

start zipkin-server\startServer.cmd
start cmd /k "cd spring-cloud-basic-zipkin-producer & mvn spring-boot:run"
start cmd /k "cd spring-cloud-basic-zipkin-consumer & mvn spring-boot:run"

TIMEOUT /T 30 /NOBREAK

start chrome.exe http://localhost:8989/weathers/today
start chrome.exe http://localhost:9411
