CREATE DATABASE IF NOT EXISTS whateverdb;
USE whateverdb;

CREATE TABLE IF NOT EXISTS events(
                       id int NOT NULL AUTO_INCREMENT,
                       event_name varchar(50) NOT NULL,
                       start_date date NOT NULL,
                       end_date date NOT NULL,
                       PRIMARY KEY (id)
);

INSERT INTO events VALUES(1, 'Charity Jose', '2020-05-11', '2020-05-12' ),
                         (2, 'Charity Andrew', '2020-05-15', '2020-05-16' ),
                         (3, 'Charity Johanna in favour of kangurus ', '2020-06-06', '2020-07-01' );
