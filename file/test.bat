runas /user:Administrator /savecred cmd 
net share IPC$

net use \\10.6.172.161\ipc$ "Yf123456" /user:Administrator

net use \\10.6.172.161\ipc$ "Yf123456" /user:Administrator

 

psexec \\10.6.172.161 -u local\Administrator -p Yf123456 cmd

ssh -p 22 Administrator@10.6.172.161

"c:\Program Files (x86)\WinSCP\WinSCP.exe" /console /command "option batch continue" "option confirm off" "open sftp://Administrator:Yf123456@10.6.172.161:22" "option transfer binary" "put F:\workspace\jenkins\waterchief\fill\target\fill.war d:/" "exit" /log=log_file.txt

C:\Program Files (x86)\WinSCP\WinSCP.exe

"c:\Program Files (x86)\WinSCP\WinSCP.exe"

ssh-copy-id Administrator@10.6.172.161


ssh Administrator@10.6.172.161 "cat >> C:\Users\Administrator\.ssh\authorized_keys" < C:\Users\shenzhanwang\.ssh\id_rsa.pub

ssh Administrator@10.6.172.161
set wshell=createobject("wscript.shell")
wshell.sendkeys "Yf123456"&chr(10)


plink Administrator@10.6.172.161 -pw Yf123456

mkgroup -l >> C:\Program Files\OpenSSH\etc\group

sc.exe create "sshd" binPath=" C:\Program Files\OpenSSH\bin\sshd.exe agent -dev"

sc.exe start “Consul”

ssh-keygen -t rsa  -F C:\Program Files\OpenSSH\home\Administrator\.ssh\


 netsh advfirewall firewall add rule name=sshd dir=in action=allow protocol=TCP localport=22
 
 icacls administrators_authorized_keys /inheritance:r

icacls administrators_authorized_keys /grant SYSTEM:(F)

icacls administrators_authorized_keys /grant BUILTIN\Administrators:(F)

ssh -p 22 -i ‪C:\Users\shenzhanwang\.ssh\id_rsa Administrator@10.6.172.161

ssh -i id_rsa -N -L 0.0.0.0:3306:localhost:3306 administrator@10.6.172.161

ssh --% Administrator@10.6.172.161 powershell -c $ConfirmPreference = 'None'; Repair-AuthorizedKeyPermission C:\Users\Administrator\.ssh\authorized_keys

"c:\Program Files" /console /command "option batch continue" "option confirm off" "open sftp://Administrator:Yf123456@10.6.172.161:22" "option transfer binary" "put F:\workspace\jenkins\waterchief\fill\target\fill.war d:/" "exit" /log=log_file.txt  


scp F:\workspace\jenkins\waterchief\fill\target\fill.war Administrator@10.6.172.161:d:\

@exit /b 0 返回值