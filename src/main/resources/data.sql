INSERT INTO player (id, nickname, first_name, last_name, team_id)
VALUES
    (1, 's1mple', 'Oleksandr', 'Kostyliev', 1),
    (2, 'electronic', 'Denis', 'Sharipov', 1),
    (3, 'Boombl4', 'Egor', 'Vasilyev', 1),
    (4, 'flamie', 'Egor', 'Vasilev', 1),
    (5, 'B1T', 'Egor', 'Vasilev', 1);
INSERT INTO team (id, name)
VALUES
    (1, 'Astralis'),
    (2, 'Natus Vincere'),
    (3, 'Vitality'),
    (4, 'G2 Esports'),
    (5, 'Team Liquid');
INSERT INTO my_event (id, name, date, place_id)
VALUES
    (1, 'ELEAGUE Major: Atlanta 2017', '2017-01-22', 1),
    (2, 'PGL Major Kraków 2017', '2017-07-16', 2),
    (3, 'ELEAGUE Major: Boston 2018', '2018-01-12', 3),
    (4, 'FACEIT Major: London 2018', '2018-09-05', 4),
    (5, 'IEM Katowice 2019', '2019-02-14', 5);
INSERT INTO event_place (id, name, country, city)
VALUES
    (1, 'Fox Theatre', 'United States', 'Atlanta'),
    (2, 'TAURON Arena Kraków', 'Poland', 'Kraków'),
    (3, 'Agganis Arena', 'United States', 'Boston'),
    (4, 'Wembley Arena', 'United Kingdom', 'London'),
    (5, 'Spodek Arena', 'Poland', 'Katowice');
