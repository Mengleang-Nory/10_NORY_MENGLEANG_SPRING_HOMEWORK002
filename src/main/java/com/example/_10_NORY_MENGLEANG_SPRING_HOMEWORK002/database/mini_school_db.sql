create database mini_school_db;

create table instructors
(
    instructor_id   serial primary key,
    instructor_name varchar(100) not null,
    email           varchar(100) not null
);

create table courses
(
    course_id     serial primary key,
    course_name   varchar(100)                                                                   not null,
    description   varchar(250),
    instructor_id int references instructors (instructor_id) on update cascade on delete cascade not null
);

create table students
(
    student_id   serial primary key,
    student_name varchar(100) not null,
    email        varchar(100) not null,
    phone_number varchar(100) not null
);

create table student_course
(
    student_id int references students (student_id) on update cascade on delete cascade not null,
    course_id  int references courses (course_id) on update cascade on delete cascade   not null
);

insert into instructors (instructor_name, email)
values ('John Doe', 'john.doe@school.com'),
       ('Alice Smith', 'alice.smith@school.com'),
       ('Michael Brown', 'michael.brown@school.com');

insert into courses (course_name, description, instructor_id)
values ('Introduction to Programming', 'Basic programming concepts using Python', 1),
       ('Database Management', 'Fundamentals of database design and SQL', 2),
       ('Web Development', 'HTML, CSS, JavaScript, and modern web frameworks', 3),
       ('Cybersecurity Basics', 'Introduction to security principles and practices', 1),
       ('Data Science Essentials', 'Data analysis and visualization techniques', 2);

insert into students (student_name, email, phone_number)
values ('Sophia Lee', 'sophia.lee@student.com', '0123456789'),
       ('James Carter', 'james.carter@student.com', '0987654321'),
       ('Emily Johnson', 'emily.johnson@student.com', '0112233445'),
       ('Daniel White', 'daniel.white@student.com', '0223344556'),
       ('Olivia Brown', 'olivia.brown@student.com', '0334455667');

insert into student_course (student_id, course_id)
values (1, 1),
       (1, 3),
       (2, 2),
       (2, 4),
       (3, 5),
       (3, 1),
       (4, 2),
       (4, 3),
       (5, 4),
       (5, 5);

select *
from instructors;

select *
from instructors
where instructors.instructor_id = 1;

insert into instructors(instructor_name, email)
values ('Heng', 'heng@gmail.com')
    returning *;

update instructors
set instructor_name = 'popop',
    email           = 'popop@gmail.com'
where instructor_id = 5
    returning *;

delete
from instructors
where instructor_id = 6
    returning *;

select *
from courses
         limit 3 offset 0;

select *
from courses
where course_id = 1;

insert into courses(course_name, description, instructor_id)
values ('popo', 'kingkong', 12)
    returning *;

update courses
set course_name   = 'koko',
    description   = 'popo',
    instructor_id = 1
where course_id = 1
    returning *;

select *
from students;

select *
from courses as c
         inner join student_course as sc on c.course_id = sc.course_id
where student_id = 1;

select *
from students
where student_id = 1;

insert into students (student_name, email, phone_number)
values ('leang', 'leangleang', '0987543')
    returning student_id;

insert into student_course (student_id, course_id)
values (1,2);

delete from students where student_id = 8;

insert into students(student_id,student_name,email, phone_number)
values (8,'leang','leangleang','09876543')
    returning student_id;

