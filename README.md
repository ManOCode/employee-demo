# employee-demo

This project contains an employee-server which is run on the server side for the management of employee data of a company or organization.

## Getting Started
### Prerequisites
```
Java JDK(with JRE) 1.8
Eclipse Oxygen
Maven
Git
```

### Installing

```
1. Install Java JDK(with JRE) 1.8 and don't forget to setup the system environment variable(JAVA_HOME) pointing to the correct java home destination.
```

```
2.Install Eclipse Oxygen(Any directory is fine)

2.1 Make sure Java 1.8 is added in 
window > preferences > java > installed jres

2.1 M2E(Maven) module should be installed with in eclipse
>> https://projects.eclipse.org/projects/technology.m2e
(Maven should be installed to your local aswell to be able to run the 'mvn' commands in cmd prompt)

2.3 Egit(Git) module should be install within eclipse for respository connection
>> https://projects.eclipse.org/projects/technology.egit
```

```
3. After all modules are installed, run the maven project update.
right click(employee-demo) > maven > update project..
(should install all required dependencies to complete testing below)
```


## Running the tests

employee-server has three area's of testing, all tests are done through the JUnitTest class going in the order below, please execute the JUnitTest.java in JUnit for the testing to begin:

```
JUnitDaoTest - Tests the connect to the Hibernate database for communication of storing and receiving the required information to which will allow the API to communicate with the client, returning the needed information. 
```

```
JUnitServiceTest - Tests the business logic making sure the information sent from the API DTO to the database Models is working correctly, this plays an important part connecting the Database to the API.
```

```
JUnitResourceTest - Tests the information to which the client will be inserting making sure the security is correct and the information which is return is valid and in sync with the database layer.
```


## Built With

```
SpringFrameworks
RestEasy
Hibernate
```


## Authors

```
Jean-Paul De Villiers
```

