CREATE TABLE tmis_user_info(
  user_id VARCHAR(32) PRIMARY KEY ,
  pwd_code VARCHAR(64) NOT NULL
);

CREATE TABLE tmis_interface_service_info(
  interface_service_name VARCHAR(32) PRIMARY KEY,
  interface_service_path_info VARCHAR(256) NOT NULL
);

create table tmis_interface_service_watch_info(
	id int primary key,
    interface_service_count int,
    interface_service_call_count int,
    interface_service_server_count int
);



