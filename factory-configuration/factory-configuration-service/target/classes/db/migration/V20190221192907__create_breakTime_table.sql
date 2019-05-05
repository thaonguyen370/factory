create table if not exists break_time(
                                       break_time_id serial8 primary key,
                                       name varchar not null,
                                       start_time time not null,
                                       end_time time not null,
                                       shift_id integer not null,
                                       CONSTRAINT break_time_check_end_time_start_time CHECK (end_time > start_time)
);
