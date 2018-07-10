insert into role(name) values('ALUNO');
insert into role(name) values('PROFESSOR');
insert into role(name) values('ADM');

insert into rgm(rgm) values ('123');
insert into rgm(rgm) values ('456');
insert into rgm(rgm) values ('789');

insert into usuario(idrgm,senha) values ((select idrgm from rgm where rgm = '123'),'$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');
insert into usuario(idrgm,senha) values ((select idrgm from rgm where rgm = '456'),'$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');
insert into usuario(idrgm,senha) values ((select idrgm from rgm where rgm = '789'),'$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');

insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where idrgm = (select idrgm from rgm where rgm = '123')),(select id from role where name = 'ALUNO'));
insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where idrgm = (select idrgm from rgm where rgm = '456')),(select id from role where name = 'PROFESSOR'));
insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where idrgm = (select idrgm from rgm where rgm = '789')),(select id from role where name = 'ADM'));

