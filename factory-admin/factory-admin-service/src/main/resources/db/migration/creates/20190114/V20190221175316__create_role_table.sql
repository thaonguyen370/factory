create table IF NOT EXISTS roles
(
  role_id serial primary key,
  role_name varchar  not null,
  created_by varchar not null
);