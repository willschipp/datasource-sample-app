sudo apt-get install mysql-server mysql-client
sudo mysqladmin -u root -h localhost password 'password'
mysql -u root -p
grant all privileges on *.* to 'root'@'%' identified by "password";
flush privileges;
exit

sudo vi /etc/mysql/mysqld.conf
bind-address = 0.0.0.0

mysql -u root -p
create database testdb;

