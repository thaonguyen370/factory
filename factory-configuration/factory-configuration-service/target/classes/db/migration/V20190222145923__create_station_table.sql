CREATE TABLE IF NOT EXISTS station(
                   id serial8 primary key not null,
                   station_name varchar not null,
                   factory_id int,
                   line_id int,
                   position int
);