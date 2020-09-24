I have implemented the task in Java in a maven project using [rest-assured](https://rest-assured.io/) as the main library

### PREREQUISITES

1. Java (I used openjdk 8)
2. Maven

### LIBRARIES USED

1. [rest-assured](https://rest-assured.io/)
2. [JUnit 5](https://junit.org/junit5/)
3. json-schema-validator (rest-assured)

### To Run test
clone the repository, ensure you have Java and maven installed and run the following command

`mvn clean test`

### ANSWERS TO QUESTION

#### 1 How long did the task take?
I spent a little over 4hours. 
Things I would have done if I spent a bit more time include

1. Created different classes to map Method Names and Request Parameters
2. Add a reporting tool 
3. Covered more test cases especially the unhappy paths

#### 2 What do you think is the most interesting trend in test automation?
     Visual Regression: it is the process of validating the User Interface, Displays, Content and Data of an application
     by way of screenshots then do comparison between the old and new tests for differences. Essentially
     content comparison between images.



#### 3 What is contract testing?
Contract Testing is a process of interaction between two microservices systems by securing effective compatibility
between the systems. It stores the interactions and exchanges in a contract and verify the two systems cohere.

#### 4. Please describe yourself using JSON.
```
{
  "firstname": "Tunde",
  "lastname": "Adewuyi",
  "profession": "QA Automation Engineer",
  "nationality": "British",
  "livesin": "Bedfordshire",
  "passions": [
    "Self Development",
    "Uplifting Others",
    "Health and Fitness"
  ],
  "interests": [
    "Sport",
    "Documentaries"
    "Music"
  ],
  "dreams": [
    "Travel around the world!"
  ],
  "believe": [
    "All things work together for good "
  ]
}
```

### 5. What are your thoughts on manual vs automation testing?

Manual Testing has advantages and disadvantages
Benefits
1. A tester manually execute all test cases and can detect issues at first instance and provide visual
   feedback immediately.
2. Manual testing is cheaper in a small project as it does not require tools.
3.  Manual testing is effective finding visual bugs I.e cosmetic bugs  and for usability testing

Disadvantages
1. Manual testing is time consuming and the process is slow and regression testing takes longer time when executing
  thousands of scripts.
2. Manual testing is costly as multiple testing resources maybe required in a big project otherwise testing coverage
  will be impacted in tight deadlines.
3. Manual testing cannot stimulate non functional testing i.e. Stress testing

Automated Testing Benefits
1. Testing is quicker,  reduces testing time, can execute complex scenarios effectively.
2. Testing is cheaper in a big project, although companies need to invest in tools such as CI/CD tools
   and regression testing is less painful to execute.
3. Automated testing can stimulate non functional testing i.e. Load and Performance, Stress testing etc
4. Automated testing has benefits to overall productivity of the development and promote quality delivery.
5. Reusability of test suites for future development

Disadvantages
1. Automated testing can't detect visual bugs and unsuitable for usability testing.
2. Some scenarios just can't be automated therefore automated testing won't cover all test scenarios
3. Valuable time is lost debugging scripts and tools may have their own defect
4. Prior programming knowledge is required

