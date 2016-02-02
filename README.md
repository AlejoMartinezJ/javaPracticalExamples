# javaPracticalExamples

HibernateSchoolManyToMany:

Model Student Course Registration.
Student: ID, Name

Course: ID, Name

A student can take many courses and a course can have many students.

1).Write code/Hibernate entity bean classes to model Student and Course and student course registration.

2). Write a Student DAO class that support

	2.1). add a new student along with their course registrations.

	2.2). Delete a student.

	2.3).Get all students, sorted by their name, for a given course with course name as input.
	
	2.4). What if we want to record course scores?
	
	2.5). How to find all students who don’t register for a given course?  

genericPriorityQueue:

Task:
implement the class com.placester.main.ThreadSafePriorityQueue as you see fit
- don't use any collections classes from java.util or java.util.collections
- This class must allow dynamic resizing as elements are added.
- do not use any containers from java.util
 
Solution:

class implemented com.placester.main.ThreadSafePriorityQueue
test: com.placester.test

ramdomRollGeneration:
Task:

Implement a 6 sided die with weights on the sides, so that we don't have an even probability distribution,
but it is weighted by a list of weights passed in at construction time After 10k iterations of throwing this die, the results should closely match the desired distribution

Solution:
class implement:  com.placester.main.SixSidedWeightedDie.java
test: com.placester.test
