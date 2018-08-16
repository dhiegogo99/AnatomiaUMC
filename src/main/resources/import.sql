insert into role(name) values('ALUNO');
insert into role(name) values('PROFESSOR');
insert into role(name) values('ADM');


insert into UserUMC(status,login,password,name,email) values (1, '123','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.','Dhiego','dhiegogo99@gmail.com');
insert into UserUMC(status,login,Password,name) values (1,'456','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.','Fernando');
insert into UserUMC(status,login,Password,name) values (1,'789','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.','Zema');
insert into UserUMC(status,login,Password) values (0,'asd','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.');
insert into UserUMC(status,login,Password,name,email) values (1, 'qwe','$2a$10$GfPrrBdtAiejRH2AuXUClu/5/nJMpctmpy9fDhk9P3naidE4e.0B.','Vanessa','vanessaps404@gmail.com');

insert into users_roles(user_id,role_id) values((select id from UserUMC where login = 'qwe'),(select id from role where name = 'ALUNO'));
insert into users_roles(user_id,role_id) values((select id from UserUMC where login = 'asd'),(select id from role where name = 'ALUNO'));
insert into users_roles(user_id,role_id) values((select id from UserUMC where login = '123'),(select id from role where name = 'ALUNO'));
insert into users_roles(user_id,role_id) values((select id from UserUMC where login = '456'),(select id from role where name = 'PROFESSOR'));
insert into users_roles(user_id,role_id) values((select id from UserUMC where login  = '789'),(select id from role where name = 'ADM'));

