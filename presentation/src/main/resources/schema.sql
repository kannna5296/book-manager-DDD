CREATE TABLE book (
  id IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  kana_title VARCHAR(255),
  author VARCHAR(255),
  kana_author VARCHAR(255),
  release_date DATETIME
);

CREATE TABLE rental (
  id IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  book_id INT,
  rental_date DATETIME,
  return_deadline DATETIME
);

CREATE TABLE student (
  id IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)
);

CREATE TABLE course (
  id IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)
);

CREATE TABLE course_like (
  student_id INT,
  course_id  INT
);