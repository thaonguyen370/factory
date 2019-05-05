create table IF NOT EXISTS users
(
  user_id serial primary key ,
  user_name varchar not null UNIQUE ,
  factory_id int not null,
  first_name varchar not null ,
  last_name varchar not null ,
  sso varchar ,
  email varchar ,
  password varchar not null
);