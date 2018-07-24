insert into role(name) values('ALUNO');
insert into role(name) values('PROFESSOR');
insert into role(name) values('ADM');


insert into usuario(status,login,senha,nome,email) values (1, '123','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.','dhiego','dhiegogo99@gmail.com');
insert into usuario(status,login,senha) values (1,'456','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');
insert into usuario(status,login,senha) values (1,'789','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');



insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where login = '123'),(select id from role where name = 'ALUNO'));
insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where login = '456'),(select id from role where name = 'PROFESSOR'));
insert into users_roles(user_id,role_id) values((select IDUsuario from USUARIO where login  = '789'),(select id from role where name = 'ADM'));

