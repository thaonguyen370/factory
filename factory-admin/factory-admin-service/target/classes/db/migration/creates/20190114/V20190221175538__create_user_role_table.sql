create table IF NOT EXISTS user_role
(
	user_id int,
	role_id int,
	CONSTRAINT user_role_pk PRIMARY KEY (user_id,role_id)
);