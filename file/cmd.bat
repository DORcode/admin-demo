title work-report
java -Dfile.encoding=UTF-8 -jar -Dspring.profiles.active=prod work-report-0.0.1-SNAPSHOT.jar --server.port=9092


netstat -ano|findstr "9092"

taskkill /pid 6960 -f

standalone.bat -Djboss.socket.binding.port-offset=100 -DJDBC_PARAMS='useSSL=false'

mvn wildfly:undeploy -Dwildfly.port=10190


mvn install:install-file -DgroupId=org.apache.shardingsphere -DartifactId=sharding-jdbc-core -Dversion=4.1.1 -Dpackaging=jar -Dfile=C:\Users\shenzhanwang\Downloads\sharding-jdbc-core-4.1.1.jar

minio.exe server F:\minio

mc admin config reset myminio crawler

/usr/sbin/mysqld --initialize --user=mysql --lower-case-table-names=1

mysqld --defaults-file=D:\mysql-8.0.12-winx64\my.ini --initialize --console

mysql -u root -p

ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';

@echo off
START "demo" javaw  -jar -Dspring.profiles.active=prod jar包路径  --server.port=9092