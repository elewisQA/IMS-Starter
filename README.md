# Inventory Management System

Inventory-Management-System is a Java program using an MySQL backend.
This project is done as part of the QA Academy.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

* Java 7 or later  

For development:   

* Eclipse or Intellij (or any other suitable IDE)
* Maven  
* MySQL 5.7 Instance

### Installing

1. To setup a development environment, you will need to clone either the master-branch or the dev-branch 
of this repository.  
2. Once the directory is cloned, open it in the IDE of your choice.  

3. Inside `src/main/java/com/qa/ims/utils/DBUtils.java` you will need to modify the 'connect()' method 
with your own database connection information. Alternatively, modify the database properties method and 
modify `src/main/java/com/qa/ims/IMS.java` to pass the file location of 'properties.db' to `connect()`.  

4. Run the 'Runner.java' class under `src/main/java/com/qa/ims` and the application should start and 
connect to your database, creating the IMS database and its tables.  

## Running the tests

All tests are located under the `src/test` directory.  

### Unit Tests 

These tests cover some basics, such as ensuring that classes like Order or Item have correct equals() and 
hashCode() methods.  
  
The tests for the Data-Access Objects (DAOs) are a bit more complex, passing in objects, ensuring they are 
processed correctly and that the correct information is passed back.  

Lastly, there are some Mockito tests for the Controller classes which simulate user-input to check that 
objects are created and handled properly.  
  
If you are using an IDE such as Intellij or Eclipse, you will be able to run these tests by right-clicking 
the classes and selecting the "Run as JUnit test" option.  
  
Alternatively, if you are working in eclipse, you can right-click the project folder and select the 
'Coverage As...' option.

## Deployment

No CI was used with this project. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

Project uses [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Jordan Harrison** - *IMS Starter* - 
[JHarry444](https://github.com/JHarry444/IMS-Starter)
* **Nick Johnson** - *Updated IMS Starter* 
[nickrstewarttds](https://github.com/nickrstewarttds/IMS-Starter)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thanks to my trainers Nick & Piers for being very helpful
* Thanks to Shafeeq for all the SQL training
