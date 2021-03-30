@echo off
START "demo" javaw  -jar -Dspring.profiles.active=dev app-gtpp-disp-0.0.1-SNAPSHOT.jar  --server.port=9092