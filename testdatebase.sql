SELECT * FROM jobdb.user;
insert into user(first_name, last_name, image, email, phone, sex, birth, username, password, role_id)
values("Khang", "Nguyễn", "link", "aa@aa.aa", "0123456","Nam", '2002-02-02', "Khang0101", "0123456", 2);
SELECT * FROM jobdb.job;
insert into job(employer_id, name, employment_type_id, salary, company, address, phone, emailcompany, date_posted)
values(2, "a,fffffvvvv", 3, 5000000, "a", "aaa", "01100000","aaa0a0a0a0a", "2023-09-07");

insert into rating(candidate_id, employer_id, star, comment)
values(3, 2, 1, "bad");