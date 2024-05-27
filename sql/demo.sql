use demo

create table users (
	id int not null identity(100,1),
	name varchar(120) not null,
	email varchar(220) not null,
	country varchar(120),
	primary key(id)
)
