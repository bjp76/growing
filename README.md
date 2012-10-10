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
 This module contains a simple SpringMVC + Hibernate webapp along with the following kinds of tests
   - JUnit tests, with EasyMock
   - JUnit tests using DbUnit to test Repository layer
   - Feature tests using cucumber-jvm

 TODOs
 -----
    - Javascript tests using jasmine.

FAQ
----
 - How to run all tests ?
   - mvn clean test

 - How to access contacts webapp in browser ?
    - cd contacts
    - mvn clean install jetty:run
    - Then in browser access the url: http://localhost:8080/

 - How to run *only* automated cucumber tests ?
   -  cd contacts
   - mvn clean verify -Pintegration-tests

 - How to run automated cucumber tests in IE or Chrome or Firefox ?
   - Use -Dbrowser=IE for IE  , -Dbrowser=chrome for Chrome , default is Firefox

   The following will run the test against IE browser.
   - mvn clean verify -Pintegration-tests -Dbrowser=ie

