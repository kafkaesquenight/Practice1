CREATE TABLE player (
                        player_id INT PRIMARY KEY,
                        player_nickname VARCHAR(255),
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        player_team_id INT
);
CREATE TABLE team (
                       team_id INT PRIMARY KEY,
                       team_name VARCHAR(255)
);
CREATE TABLE event (
                       event_id INT PRIMARY KEY,
                       event_name varchar(255),
                       event_date date
);
CREATE TABLE event_place (
                       event_place_id INT PRIMARY KEY,
                       name varchar(255),
                       country varchar(255),
                       city varchar(255)
);

