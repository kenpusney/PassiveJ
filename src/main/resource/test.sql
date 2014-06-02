create table x (
  id integer primary key,
  a varchar(10) unique not null,
  that integer check that > 18,
);