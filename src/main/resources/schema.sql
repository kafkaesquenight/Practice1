
CREATE TABLE if not exists player(
                        id INT PRIMARY KEY auto_increment,
                        nickname VARCHAR(255),
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        team_id INT
);
CREATE TABLE if not exists team (
                       id INT PRIMARY KEY auto_increment,
                       name VARCHAR(255)
);
CREATE TABLE if not exists my_event (
                       id INT PRIMARY KEY auto_increment,
                       name varchar(255),
                       date date,
                       place_id INT
);
CREATE TABLE if not exists event_place (
                       id INT PRIMARY KEY auto_increment,
                       name varchar(255),
                       country varchar(255),
                       city varchar(255)
);
