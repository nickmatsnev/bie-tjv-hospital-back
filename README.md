# Hospital System
## FIT CTU BIE-TJV 2022 semester project,
### by Nikita Matsnev

## 1.  Description
    
This is a project for BIE-TJV implemented by Nikita Matsnev in 2022 winter semester.
The domain is hospital where Patient with known email(unique), name and surname can have 
Operation at some specific time
and there is a Doctor at each operation, and we know about him his name, surname and his
specialization. we can determine actual time of Operation after it is done and we track it by its status 
and each patient has a medical records book where all the performed operations are seen and also the information 
about receiving doctors. Doctors can see finished and upcoming Operations. They can create Operation slots.
There are several constraints such as Doctor cannot be at two Operations at the same or overlapping time.
Patient cannot attend several Operations at the same or overlapping time.

### 1.1. Server
Server will be implemented in Java Spring. I wil use `jdk18` and `Java 17`. Spring Web will be used
to provide RestAPI.

### 1.2. Web client
I am planning on using the Reactive Stack and Spring WebFlux, but it might differ as it is quite uncertain now.

### 1.3. Database
PostgresSQL will be used, I have already created a schema.
![Scheme](databaseScheme.png)
## 2. Build
* [Official Gradle documentation](https://docs.gradle.org)
## 3. Run
* [Official Gradle documentation](https://docs.gradle.org)
## 4. Test
junit tests