FROM mysql:8.0

ADD ./data/sql-mode.cnf /etc/mysql/conf.d/sql-mode.cnf
ADD ./data /docker-entrypoint-initdb.d

CMD ["mysqld"]