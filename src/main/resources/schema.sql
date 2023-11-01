drop table if exists player cascade;
drop table if exists team cascade;
drop table if exists my_event cascade;
drop table if exists event_place cascade;

CREATE TABLE player (
                        id INT PRIMARY KEY auto_increment,
                        nickname VARCHAR(255),
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        team_id INT
);
CREATE TABLE team (
                       id INT PRIMARY KEY auto_increment,
                       name VARCHAR(255)
);
CREATE TABLE my_event (
                       id INT PRIMARY KEY auto_increment,
                       name varchar(255),
                       date date,
                       place_id INT
);
CREATE TABLE event_place (
                       id INT PRIMARY KEY auto_increment,
                       name varchar(255),
                       country varchar(255),
                       city varchar(255)
);
