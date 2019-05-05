create table if not exists shift(
                                  shift_id serial8 primary key,
                                  name varchar not null,
                                  start_time time not null,
                                  end_time time not null,
                                  day_of_week varchar not null,
                                  line_id integer not null,
                                  CONSTRAINT shift_check_end_time_start_time CHECK (end_time > start_time)
);
