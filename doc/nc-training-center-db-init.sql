INSERT INTO knowledge_type(id, description) VALUES (1, 'java');
INSERT INTO knowledge_type(id, description) VALUES (2, 'c++');
INSERT INTO knowledge_type(id, description) VALUES (3, 'c#');
INSERT INTO knowledge_type(id, description) VALUES (4, 'PHP');
INSERT INTO knowledge_type(id, description) VALUES (5, 'JavaScript');
INSERT INTO knowledge_type(id, description) VALUES (6, 'Python');
INSERT INTO knowledge_type(id, description) VALUES (7, 'Objective-C');
INSERT INTO knowledge_type(id, description) VALUES (8, 'Ruby');
INSERT INTO knowledge_type(id, description) VALUES (9, 'Perl');
INSERT INTO knowledge_type(id, description) VALUES (10, '1C');

INSERT INTO position(id, description) VALUES (1, 'QA');
INSERT INTO position(id, description) VALUES (2, 'DEV');

INSERT INTO resume_status(id, description) VALUES (1, 'NOT_CHECKED');
INSERT INTO resume_status(id, description) VALUES (2, 'CORRECT');
INSERT INTO resume_status(id, description) VALUES (3, 'ERROR');

INSERT INTO role(id, description) VALUES (1, 'User');
INSERT INTO role(id, description) VALUES (2, 'Admin');
INSERT INTO role(id, description) VALUES (3, 'Interviewer');
INSERT INTO role(id, description) VALUES (4, 'HR');
INSERT INTO role(id, description) VALUES (5, 'SimpleHR');
INSERT INTO role(id, description) VALUES (6, 'Mail');

INSERT INTO user_status(id, description) VALUES (1, 'STEP_1');
INSERT INTO user_status(id, description) VALUES (2, 'STEP_2');
INSERT INTO user_status(id, description) VALUES (3, 'STEP_3');
INSERT INTO user_status(id, description) VALUES (4, 'BAD_RESUME');
INSERT INTO user_status(id, description) VALUES (5, 'VERIFICATION');
INSERT INTO user_status(id, description) VALUES (6, 'EDITING');
INSERT INTO user_status(id, description) VALUES (7, 'SUBMISSION');

INSERT INTO institute(id, description) VALUES (1, 'Одесский национальный политехнический университет');
INSERT INTO institute(id, description) VALUES (2, 'Одесский национальный университет им.И.И.Мечникова');
INSERT INTO institute(id, description) VALUES (3, 'Одесская национальная академия связи им.А.С.Попова');
INSERT INTO institute(id, description) VALUES (4, 'Одесская национальная академия пищевых технологий');
INSERT INTO institute(id, description) VALUES (5, 'Одеський национальный морской университет');
INSERT INTO institute(id, description) VALUES (6, 'Одесский государственный экологический университет');
INSERT INTO institute(id, description) VALUES (8, 'Другое');

ALTER TABLE MAIL_QUEUE MODIFY MESSAGE_BODY VARCHAR2(1200) ;

/*
create user nc1 identified by 1234;
grant connect, RESOURCE, create table to nc1;
*/
commit;

insert into users values (1, 'admin', 'e49b91970b98590fcda88caaf88094bb', NULL, 0, 2); -- test_2019_admin
insert into users values (2, 'hr', '492ae82b7f7b8def21e246d8abbabe32', NULL, 0, 4); --test_2019_hr
insert into users values (3, 'inter', '473540d8341c91a7b255575e45cc60b6', NULL, 0, 3); -- test_2019_inter
insert into users values (4, 'shr', '7b90b522886605dc7632529ba2334ec5', NULL, 0, 5); -- test_2019_shr

commit;

update  institute set description = 'Одесский национальный политехнический университет' where id = 1;
update  institute set description = 'Одесский национальный университет им.И.И.Мечникова' where id = 2;
update  institute set description = 'Одесская национальная академия связи им.А.С.Попова' where id = 3;
update  institute set description = 'Одесская национальная академия пищевых технологий' where id = 4;
update  institute set description = 'Одеський национальный морской университет' where id = 5;
update  institute set description = 'Одесский государственный экологический университет' where id = 6;
update  institute set description = 'Другое' where id = 8;

commit;