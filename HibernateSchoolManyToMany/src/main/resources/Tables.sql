CREATE TABLE `STUDENTS` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(45) NOT NULL,
  PRIMARY KEY (`student_id`)
) 

CREATE TABLE `COURSES` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  PRIMARY KEY (`course_id`)
)
CREATE TABLE `STUDENTS_COURSES` (
  `student_course_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`student_course_id`),
  KEY `fk_student` (`student_id`),
  KEY `fk_course` (`course_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
)