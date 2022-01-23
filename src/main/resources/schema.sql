create table if not exists users (
  id serial not null,
  name varchar(40) not null,
  password varchar(20),
  primary key (id)
);

create table if not exists sessions (
  id serial not null,
  token varchar(16) not null,
  user_id int not null,
  params varchar(255),
  primary key (id)
);
