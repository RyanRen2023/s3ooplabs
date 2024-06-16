
CST8288 010 Assignment 1 Report
Student Name: Xihai Ren
Student Number: 041127486
1.	UML 
The main package is controller, while the other packages just show the relevant classes.
 
The main package is employee, while the other packages just show the relevant classes.
 
The main package is persistence, while the other packages just show the relevant classes. 
2.	New Introduced Class
1.	EmployeeValidator: Validates the Employee object to ensure data integrity.
2.	EmployeeFormatter: Provides methods to format Employee String data.
3.	ContractEmployeeService: Defines services specific to contract employees.
4.	ContractEmployeeServiceImpl: Implements the ContractEmployeeService interface.
5.	PermanentEmployeeService: Defines services specific to permanent employees.
6.	PermanentEmployeeServiceImpl: Implements the PermanentEmployeeService interface
7.	PermanentEmployee: Represents permanent employees as a subclass of the Employee class, including attributes specific to permanent employees like years of service, total compensation, and bonuses.
8.	ContractEmployee: Represents contract employees as a subclass of the Employee class, including attributes specific to contract employees such as contract renewal dates.
9.	EmployeeServiceFactory: A factory class that creates appropriate EmployeeService instances based on the type of employee, following the Simple Factory Design Pattern.
10.	PersistenceService: A service class responsible for persisting employee data, saving formatted employee data in different formats.
11.	TextFormatter: Implements the Formatter interface, responsible for saving the Employee object as key-value pairs, such as name=xxxx, email=xyz@abc.com. Provides an additional format option for persisting employee data.
3.	 Application of SOLID Principles
1.	Single Responsibility Principle 
•	The EmployeeController class was split into EmployeeValidator, EmployeeFormatter, and PersistenceService to adhere to the Single Responsibility Principle.
2.	Open/Closed Principle 
•	PermanentEmployee and ContractEmployee inherit from Employee. TextFormatter and JSONFormatter implement the Formatter interface, adhering to the Open/Closed Principle
•	The EmployeeServiceFactory class adheres to the Open/Closed Principle by allowing the creation of new types of EmployeeService without modifying existing code.
3.	Liskov Substitution Principle 
•	PermanentEmployee and ContractEmployee are added to follow the Liskov Substitution Principle, ensuring that subclasses can be substituted for their base class without affecting the program's correctness.

4.	Interface Segregation Principle 
The EmployeeService interface was split into ContractEmployeeService and PermanentEmployeeService, ensuring that clients only need to know about the methods that are relevant to them, adhering to the Interface Segregation Principle 

5.	Dependency Inversion Principle 
•	EmployeeServiceFactory, EmployeeValidator, EmployeeFormatter, and PersistenceService are passed as parameters to EmployeeController. The Formatter interface is passed as a parameter to PersistenceService, adhering to the Dependency Inversion Principle.
![image](https://github.com/RyanRen2023/s3ooplabs/assets/148353217/8aa30e36-4b73-4252-a659-63cd35e494a4)

