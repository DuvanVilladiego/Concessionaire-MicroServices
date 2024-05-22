create table Cars (
	id SERIAL primary key,
	nombre varchar not NULL,
	precio double precision not null	
);

CREATE TABLE concessionaries (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

insert into Cars (nombre, precio)
values ('carro A', 99.00);
insert into Cars (nombre, precio)
values ('carro B', 99.00);
insert into Cars (nombre, precio)
values ('carro C', 99.00);
insert into Cars (nombre, precio)
values ('carro D', 99.00);
insert into Cars (nombre, precio)
values ('carro E', 99.00);
select * from Cars

INSERT INTO concessionaries (nombre) VALUES ('Concesionario A');
INSERT INTO concessionaries (nombre) VALUES ('Concesionario B');
INSERT INTO concessionaries (nombre) VALUES ('Concesionario C');
INSERT INTO concessionaries (nombre) VALUES ('Concesionario A');
INSERT INTO concessionaries (nombre) VALUES ('Concesionario B');
INSERT INTO concessionaries (nombre) VALUES ('Concesionario C');
select * from concessionaries
