CREATE DATABASE event_db;
GRANT ALL PRIVILEGES ON event_db.* TO root  WITH GRANT OPTION;

USE event_db;

CREATE TABLE events(
   id int NOT NULL AUTO_INCREMENT,
   event_name varchar(50) NOT NULL,
   start_date date NOT NULL,
   end_date date NOT NULL,
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


INSERT INTO events(event_name, start_date, end_date)
    VALUES ('evento 1', '10-05-2020', '11-05-2020'),
           ('evento 2', '10-05-2020', '11-05-2020'),
           ('evento 3', '10-05-2020', '11-05-2020');