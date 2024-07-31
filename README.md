# Trello Clone Backend

This repository contains the backend implementation for a Trello clone application. The backend is built using Spring Boot and provides RESTful APIs for user authentication, project management, and task management.

## Features

- **User Authentication**: 
  - Registration with name, email, and password
  - Login functionality
  - JWT-based authentication for securing APIs

- **Dashboard**:
  - Users can view two tabs: Projects and Task Board

- **Projects**:
  - Create new projects with a name and description
  - View details of each project along with the tasks associated with it
  - Add new tasks to a project

- **Task Board**:
  - View all tasks from all projects
  - Tasks are divided into various columns based on their status (e.g., Backlog, In Discussion, In Progress, Done)

- **Tasks**:
  - Tasks have attributes such as project, name, detailed description, status, tags, due date, and assigned user
  - Proper validation for all form fields on both frontend and backend

- **Security**:
  - All APIs and pages are authenticated
  - Only the login or registration page is visible to unauthenticated users

## Technologies Used

- **Spring Boot**: For building the backend RESTful APIs
- **Spring Security**: For securing the application
- **JWT**: For token-based authentication
- **H2 Database**: In-memory database for development and testing
- **JPA/Hibernate**: For database interactions

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Postman (for testing the APIs)

### Running the Application
  
Clone the repository🔽

- git clone https://github.com/ishitaaagupta/trello-clone.git

- cd trello-clone

Build the project using Maven:

- mvn clean install

Run the application:

Access the application:

- The application will be accessible at http://localhost:8080.

**API Documentation**

__User Authentication__

***1)Register User***

URL: /api/auth/register

 Method: POST

 Request Body:Json

Steps to Test in Postman:

- Open Postman.

- Create a new POST request.

- Set the URL to http://localhost:8080/api/auth/register.

- In the Body tab, select raw and JSON from the dropdown.

- Copy and paste the request body JSON.

- Click Send.

 
 ***2)Login User***
 
URL: /api/auth/login

Method: POST

Request Body:Json

Steps to Test in Postman:

- Create a new POST request.

- Set the URL to http://localhost:8080/api/auth/login.

- In the Body tab, select raw and JSON from the dropdown.

- Copy and paste the request body JSON.

- Click Send.

- Copy the token from the response


***3)Projects***


**->Create Project**

URL: /api/projects/create

Method: POST

Authorization: Bearer your-jwt-token

Request Body:json

Steps to Test in Postman:

- Create a new POST request.

- Set the URL to http://localhost:8080/api/projects/create.

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- In the Body tab, select raw and JSON from the dropdown.

- Copy and paste the request body JSON.

- Click Send.


**->Get All Projects**

URL: /api/projects

Method: GET

Authorization: Bearer your-jwt-token

Steps to Test in Postman:

- Create a new GET request.

- Set the URL to http://localhost:8080/api/projects.

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- Click Send


**->View Details of Each Project Along with the Tasks Associated with It**

URL: /api/projects/{projectId}

Method: GET

Authorization: Bearer your-jwt-token

Steps to Test in Postman:

- Create a new GET request.

- Set the URL to http://localhost:8080/api/projects/{projectId} (replace {projectId} with an actual project ID).

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- Click Send.

***4)Tasks***


**->Create Task**

URL: /api/projects/{projectId}/tasks/create

Method: POST

Authorization: Bearer your-jwt-token

Request Body:json

Steps to Test in Postman:

- Create a new POST request.

- Set the URL to http://localhost:8080/api/projects/{projectId}/tasks/create (replace {projectId} with an actual project ID).

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- In the Body tab, select raw and JSON from the dropdown.

- Copy and paste the request body JSON.

- Click Send.


**->Add New Tasks to a Project**

URL: /api/projects/{projectId}/tasks/create

Method: POST

Authorization: Bearer your-jwt-token

Request Body: JSON

Steps to Test in Postman:

- Create a new POST request.

- Set the URL to http://localhost:8080/api/projects/{projectId}/tasks/create (replace {projectId} with an actual project ID).

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- In the Body tab, select raw and JSON from the dropdown.

- Copy and paste the request body JSON.

- Click Send.


**->View All Tasks from All Projects**

URL: /api/tasks

Method: GET

Authorization: Bearer your-jwt-token

Steps to Test in Postman:

- Create a new GET request.

- Set the URL to http://localhost:8080/api/tasks.

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- Click Send.


 ***->Get Tasks by Status***
 
 URL: /api/tasks/status/{status}
 
Method: GET

Authorization: Bearer your-jwt-token

Steps to Test in Postman:

- Create a new GET request.

- Set the URL to http://localhost:8080/api/tasks/status/{status} (replace {status} with one of the statuses: Backlog, In Discussion, In Progress, Done).

- In the Authorization tab, select Bearer Token and paste the copied JWT token.

- Click Send.




***--Example Usage--***

To get all tasks in the "Backlog" status:
Set the URL to http://localhost:8080/api/tasks/status/Backlog

To get all tasks "In Discussion":
Set the URL to http://localhost:8080/api/tasks/status/In Discussion

To get all tasks "In Progress":
Set the URL to http://localhost:8080/api/tasks/status/In Progress

To get all tasks "Done":
Set the URL to http://localhost:8080/api/tasks/status/Done

 
***Postman Collection***

To make testing easier, you can use the provided Postman collection. Import the Trello_API.postman_collection.json file into Postman to get all the predefined requests.

1.	Open Postman.
2.	Click on the Import button.
3.	Select the Trello_API.postman_collection.json file.
4.	Use the predefined requests to test the APIs.
5.	Testing Authentication in Postman


