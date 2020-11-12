@echo off & setlocal EnableDelayedExpansion
set pidNum=0
set port=8280
for /f "tokens=5 delims= " %%i in ('netstat -aon ^| findstr !port! ^|findstr "LISTENING"') do (
	echo %%i
	set pidNum=%%i
	echo echo 端口号【!port!】进程为【!pidNum!】
)
if "!pidNum!"=="0" (
	echo 端口号【!port!】未占用
) else (
	taskkill /pid !pidNum! -f
	echo 端口号【!port!】关闭成功
	
)
timeout /t 10
@exit
pause>nul

