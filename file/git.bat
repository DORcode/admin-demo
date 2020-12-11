git bash

git init

git remote add origin https://github.com/DORcode/keycloak-11.0.1.git (如果报错 1、先输入 git remote rm origin
2、再输入 git remote add origin**************)

git add -A
git commit -m "init"
git push -u origin master


git update-index –assume-unchanged –path 可以忽略文件
git update-index –no-assume-unchanged –path 可以取消忽略文件

git check-ignore -v pom.xml



git pull --rebase origin master

[rejected] master -> master (non-fast forward)
git pull origin master --allow-unrelated-histories //把远程仓库和本地同步，消除差异
重新 add commit
git push origin master
