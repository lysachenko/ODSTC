[Подготовка] БД и сервер:
1. Скачиваем любой application server. Например Tomcat: http://tomcat.apache.org/download-80.cgi
2. Нужна любая реляционная база данных, например: oracle, postgres, mysql.

[Подготовка] Настройка соединения с базой:
1. [unzip war]. Описание ниже
2. Открываем файл \webapps\[application]\META-INF\applicationContext.xml
3. Ищем строчку: <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">. Ниже есть конфигурация соединения с бд. Меняем конфигурацию в соответствии с локальной бд.

[Подготовка] Создание БД:
1. [unzip war]. Описание ниже
2. Открываем файл \webapps\[application]\META-INF\applicationContext.xml
3. Ищем строчку: <prop key="hibernate.hbm2ddl.auto">validate</prop>.
4. Меняем "validate" на "create-drop"
5. Запускаем сервер: apache-tomcat\bin\startup. После запуска сервера приложение создаст в базе данных все необходимые таблицы и связи.
6. Теперь необходимо создать статически данные в бд. Нужно выполнить nc-training-center-db-init.sql.
7. !ВАЖНО! после этого в файле applicationContext.xml: нужно вернуть "validate" иначе после повторного запуска tomcat сервера приложение пересоздаст базу данных заново.

Запуск приложения:
1. [unzip war]. Описание ниже
2. Запускаем сервер apache-tomcat\bin\startup

[unzip war]:
1. Копируем gwt-web-app-0.1-SNAPSHOT.war (Архив можно переименовать и назвать например Odessa) в папку \apache-tomcat\webapps
2. Делаем Unzip

Добавление статических юзеров:
--insert into users(id, login, password, role_id, archive) values (1, 'admin', '9a740de85d74542f3a4f43f56db68e81', 2, false); -- user 'admin', password - 'NCadmin123'
--insert into users(id, login, password, role_id, archive) values (2, 'hr', '037376665b06bedd53aeb36c324e18d2', 4, false); -- user 'hr', password - 'NChr123'
--insert into users(id, login, password, role_id, archive) values (3, 'inter', 'a56e8417ba57b38878063fb4aa43423a', 3, false); -- user 'inter', password - 'NCinter123'
--insert into users(id, login, password, role_id, archive) values (4, 'shr', '519a30ee0e1e9c41151559775aa6c0a1', 5, false); -- user 'shr', password - 'NCshr123'

insert into users values (1, 'admin', '231de5514810584a157cc8362770dbc9', NULL, 0, 2); -- ADMINfeb2017
insert into users values (2, 'hr', 'f69cdc8d5fe0832e4f0187968d115520', NULL, 0, 4); --HRfeb2017
insert into users values (3, 'inter', '25acdae61d9e12cb6212d68bf726e0e0', NULL, 0, 3); -- INTERfeb2017
insert into users values (4, 'shr', 'e24ececdd5c656da0ad434dcf2511bab', NULL, 0, 5); -- SHRfeb2017

update users set password = '037376665b06bedd53aeb36c324e18d2' where login = 'hr';

insert into users values (1, 'admin', 'e49b91970b98590fcda88caaf88094bb', NULL, 0, 2); -- test_2019_admin
insert into users values (2, 'hr', '492ae82b7f7b8def21e246d8abbabe32', NULL, 0, 4); --test_2019_hr
insert into users values (3, 'inter', '473540d8341c91a7b255575e45cc60b6', NULL, 0, 3); -- test_2019_inter
insert into users values (4, 'shr', '7b90b522886605dc7632529ba2334ec5', NULL, 0, 5); -- test_2019_shr

commit;

update  institute set description = 'Одесский национальный политехнический университет' where id = 1
update  institute set description = 'Одесский национальный университет им.И.И.Мечникова' where id = 2
update  institute set description = 'Одесская национальная академия связи им.А.С.Попова' where id = 3
update  institute set description = 'Одесская национальная академия пищевых технологий' where id = 4
update  institute set description = 'Одеський национальный морской университет' where id = 5
update  institute set description = 'Одесский государственный экологический университет' where id = 6
INSERT INTO institute(id, description) VALUES (8, 'Другое');
