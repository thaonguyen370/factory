CREATE TABLE IF NOT EXISTS line(
                   id serial8 primary key not null,
                   line_name varchar not null,
                   line_manager varchar not null,
                   start_time timestamptz(0) not null,
                   takt_time int not null,
                   target_output int not null,
                   target_frequency varchar(30) not null,
                   factory_id int
);
CREATE TABLE IF NOT EXISTS pause_time(
                         id serial8 primary key not null,
                         name varchar,
                         start_time timestamptz(0),
                         end_time timestamptz(0),
                         line_id int
);
