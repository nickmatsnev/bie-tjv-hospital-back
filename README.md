# Hospital System
## FIT CTU BIE-TJV 2022 semester project, ready for evaluation
### by Nikita Matsnev
[![version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://gitlab.fit.cvut.cz/matsnnik/tjvhospital) \
[![version](https://img.shields.io/badge/pipeline-fixed-green.svg)](https://gitlab.fit.cvut.cz/matsnnik/tjvhospital) 


## 1.  Description
#### 1.1. Domain
This is a project for BIE-TJV implemented by Nikita Matsnev in 2022 winter semester.
The domain is hospital where Patients with known email(unique), name and surname can have
Session at some specific time
and there is a Doctor at each session, and we know about him/her his/her name, surname and
specialization. we can determine actual time of Session after it is done, and we track it by its status
and each patient has a medical records book where all the performed sessions are seen and also the information
about receiving doctor. Doctor can see finished and upcoming Sessions. They can create Session slots.
There are several constraints such as Doctor cannot be at two Sessions at the same or overlapping time.
Patient cannot attend several Sessions at the same or overlapping time.
Patient can have many sessions with many doctors and doctors can have many sessions with different patients.
Patients and Doctors are assigned to the hospital. Doctors can treat patients within the hospital.

### 1.2. Complex queries
#### 1.2.1. JPA JPQL
##### 1.2.1.1. Patients of hospital can see their doctors
I use relations of patients to their sessions to retrieve information about doctors.
##### 1.2.1.2. Doctors of hospital can see available patients
I use relations of doctors and patients to hospital to get the list of available patients, and that will connect two tables
##### 1.2.1.3. Select doctors based on their type
I will create an ability for patients to request sessions with the available doctors at the specific time based on the requested specialization using JPQL.

### 1.3. Complex business processes
#### 1.3.1. Doctor can switch a patient in a session which has not happened yet
Doctor will update the session, so the session will be updated as well as the patients' sessions will be changed. 


### 1.4. Server

Server will be implemented in Java Spring. I wil use `jdk18` and `Java 17`. Spring Web will be used
to provide RestAPI.

#### 1.4.1. How to run server(Linux/Mac/WSL)

Install Java 17
```
sudo apt install openjdk-17-jre-headless
```
Go to build/libs:
```
cd build/libs ; \
java -jar hospital-0.0.1-SNAPSHOT.jar
```
It will run!

#### API Endpoints:

[Link to OpenAPI ReadMe file](gen/README.md)

##### 1. Patients:
`GET /patients/{id}` - gets patient by id \
`PUT /patients/{id}` - updates patient with id \
`DELETE /patients/{id}` - deletes patient with id \
`POST /patients/register` - registers patient with id and given body \
`POST /patients/login` - check if patient with email exists and password matches
##### 2. Doctors:
`GET /doctors/{id}` - gets doctor by id \
`PUT /doctors/{id}` - updates doctor with id \
`DELETE /doctors/{id}` - deletes doctor with id \
`POST /doctors/register` - registers doctor with id and given body \
`POST /doctors/login` - check if doctor with email exists and password matches
##### 3. Sessions:
`GET /session/{id}` - gets session by id \
`PUT /session/{id}` - updates session with id \
`DELETE /session/{id}` - deletes session with id \
`POST /session/create` - creates session with id and given body \
`GET /session/doctor/{id}` - gets this doctor sessions \
`GET /session/patient/{id}` - gets this patient sessions \
`GET /session/name/{doctor}/{name}` - gets session with this doctor and name \
`POST /session/name/{doctor}/{name}` - updates session with this doctor and name
##### 3. Request Sessions:
`GET /requests/{id}` - gets request session by id \
`PUT /requests/{id}` - updates request session with id \
`DELETE /requests/{id}` - deletes request session with id \
`POST /requests/create` - creates request session with id and given body \
`GET /requests/doctor/{id}` - gets this doctor request sessions \
`GET /requests/patient/{id}` - gets this patient request sessions \
`GET /requests/name/{doctor}/{name}` - gets request session with this doctor and name \
`POST /requests/name/{doctor}/{name}` - updates request session with this doctor and name \
`GET /requests/penging/doctor/{doctor}` - get pending request sessions with this doctor \
`GET /requests/penging/patient/{patient}` - get pending request sessions with this patient \
`GET /requests/rejected/doctor/{doctor}` - get rejected request sessions with this doctor \
`GET /requests/rejected/patient/{patient}` - get rejected request sessions with this patient 


### 1.5. Web client
I am planning on using the Reactive Stack and Spring WebFlux, and I use it. I also use Thymeleaf for templating. And Seneca's letters for contemplating:D.

### 1.6. Database
PostgresSQL will be used, I have already created a schema. It has two many-to-many relations.
![Scheme](databaseScheme.png)
## 2. Build
* [Official Gradle documentation](https://docs.gradle.org)
## 3. Run
* [Official Gradle documentation](https://docs.gradle.org)
## 4. Test
junit tests
