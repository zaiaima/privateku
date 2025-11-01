CREATE DATABASE student;
USE student;

CREATE TABLE student (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  sex ENUM('男', '女') NOT NULL,
  age INT NOT NULL
);
INSERT INTO student (name, sex, age) VALUES
('张三', '男', 18),
('李四', '女', 19),
('王五', '男', 20);
select * from student;
INSERT INTO student (name,sex,age) VALUES ('老师', '男', 37);
INSERT INTO student (name,sex,age) VALUES ('女老师', '女', 20);
delete from student where id =2;