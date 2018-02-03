INSERT INTO role(user_role)VALUES ('User');
INSERT INTO role(user_role)VALUES ('Admin');

INSERT INTO employee(first_name,last_name,login,email,phone_number,role_id,password)VALUES('Елена', 'Лисовец','Elena','elana@mail.ru','+380509738744', 2, 'qwerty');
INSERT INTO employee(first_name,last_name,login,email,phone_number,role_id,password)VALUES('Ира', 'Ира','Ira','iraa@mail.ru','+05097378744', 1, 'qwerty');
INSERT INTO employee(first_name,last_name,login,email,phone_number,role_id,password)VALUES('Света', 'Света','Svra','irasa@mail.ru','+380999738744', 1, 'qwerty');

INSERT INTO patient(first_name,last_name,PATRONYMIC,phone_number,date_of_birth,date_of_first_visit,diagnosis,employee_id)VALUES('Сидор','Сидоров','Сидорович','0661234567','01-01-1991','01-15-2018','Волчанка',1);
INSERT INTO patient(first_name,last_name,PATRONYMIC,phone_number,date_of_birth,date_of_first_visit,diagnosis,employee_id)VALUES('Иван','Иванов','Иванович','0661334567','10-12-1880','01-15-2018','Гранулематоз Вегенера',2);
INSERT INTO patient(first_name,last_name,PATRONYMIC,phone_number,date_of_birth,date_of_first_visit,diagnosis,employee_id)VALUES('Петр','Петров','Петрович','0561334567','12-02-1972','09-25-2017','Синдром Мюнхгаузена',2);
INSERT INTO patient(first_name,last_name,PATRONYMIC,phone_number,date_of_birth,date_of_first_visit,diagnosis,employee_id)VALUES('Илья','Илльичев','Ильич','0991334567','12-12-1980','10-05-2016','Гиппопотомомонстросесквиппедалиофобия',1);

INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2018-01-04','Общий анализ крови',1,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2018-01-05','Общий анализ мочи',1,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2018-01-06','Рентген',2,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2018-01-08','Электрокардиограмма',1,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2017-08-18','УЗИ',2,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2017-08-25','Бакпосев из глаза на анализаторе + антибиотикограмма',2,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2017-08-25','Кариотипирование (кровь, синдромы Прадера-Вилли/Ангельмана, GTG- и FISH-методы)',3,null);
INSERT INTO analysis(ANALYSIS_DATE,ANALYSIS_NAME,PATIENT_ID,ANALYSIS_PICTURE)VALUES('2017-08-25','Bordetella pertussis, антитела IgG (метод Вестернблот)',4,null);

INSERT INTO appointments(APPOINTMENTS_DATE,APPOINTMENTS_PICTURE,PATIENT_ID)VALUES('2017-08-25',null,1);
INSERT INTO appointments(APPOINTMENTS_DATE,APPOINTMENTS_PICTURE,PATIENT_ID)VALUES('2017-08-25',null,2);
INSERT INTO appointments(APPOINTMENTS_DATE,APPOINTMENTS_PICTURE,PATIENT_ID)VALUES('2017-08-25',null,3);