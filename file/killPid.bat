@echo off & setlocal EnableDelayedExpansion
set pidNum=0
set port=8280
for /f "tokens=5 delims= " %%i in ('netstat -aon ^| findstr !port! ^|findstr "LISTENING"') do (
	echo %%i
	set pidNum=%%i
	echo echo �˿ںš�!port!������Ϊ��!pidNum!��
)
if "!pidNum!"=="0" (
	echo �˿ںš�!port!��δռ��
) else (
	taskkill /pid !pidNum! -f
	echo �˿ںš�!port!���رճɹ�
	
)
timeout /t 10
@exit
pause>nul

