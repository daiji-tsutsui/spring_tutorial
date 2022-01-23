create table if not exists users (
  id serial not null,
  name varchar(40) not null,
  password varchar(20),
  primary key (id)
);
