# Customer Web App Service

This is a web application service for managing customers. 

### API Endpoints
The following table lists the RESTful API endpoints that the application provides:
| HTTP Method | API Endpoint          | Description                                               |
|-------------|-----------------------|-----------------------------------------------------------|
| GET         | /customers            | Get all customers                                         |
| GET         | /customer/{id}        | Get customer by ID                                        |
| POST        | /customer             | Create a new customer                                     |
| DELETE      | /customer/{id}        | Delete an existing customer                               |
| PUT         | /customer/{id}        | Update an existing customer, specified by ID              |