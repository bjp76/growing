growing
=======

Simple collection of projects that shows my capabilities. At the moment the project have 2 modules
 - sorters
 - contacts

 You may need JDK 1.6 and Maven 3.0.4 to run and verify the examples.

sorters
--------
 This module contains implementation of Sorting algorithms (Bubble Sort and Merge Sort) along with unit testcases written in JUnit.

contacts
--------
 This module contains a simple SpringMVC + Hibernate webapp (downloaded from internet and modified) along with the following kinds of tests
   - JUnit tests, with EasyMock
   - JUnit tests using DbUnit to test Repository layer
 I will add to this app support for the following
    - Feature tests using cucumber-jvm
    - Javascript tests using jasmine.

FAQ
-----------
 - How to rul all tests ?
   - mvn clean test

 - How to access contacts webapp in browser ?
    - mvn clean install jetty:run
    - Then in browser access the url: http://localhost:8080/
