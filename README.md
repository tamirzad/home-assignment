# Spring Boot Home assignment
(Eureka Server, Config Server, API Gateway, JWT, Authentication, Authorization, Postgres, Docker)

# About the project

<ul style="list-style-type:disc">
  <li>This project is based Spring Boot Microservices</li>
  <li>User can register and login through auth service by user role (ADMIN or USER) through api gateway</li>
  <li>User can send any request to relevant service through api gateway with its bearer token except 2 of them 
that aren't protected.</li>
</ul>

6 services with 1 module whose name are shown below have been devised within the scope of this project.

- Config Server
- Eureka Server
- API Gateway
- Auth Service
- Garment Service
- User Service
- Common module

### 🔨 Run the App

<b>Local</b>

<b>1 )</b> Clone project `git clone https://github.com/tamirzad/home-assignment.git`

<b>2 )</b> Go to the project's home directory :  `cd home-assignment`

<b>3 )</b> Run docker compose <b>`docker compose up`</b> Execute sql file to create database (In next version will be added in docker file)</b>
        
<b>4 )</b> Run <b>Eureka Server</b>

<b>5 )</b> Run <b>Gateway</b>

<b>6 )</b> Run <b>Config Server</b>

<b>7 )</b> Build common mode (First clean then install)</b>

<b>8 )</b> Run other services (<b>auth-service</b>, <b>user-service</b>, <b>garment-service</b>)

<b>9 )</b> For swagger ui localhost:8080/v1/{service-name}/swagger-ui/index.html</b>


## Valid Request Body

##### <a id="register"> Register for User

``` 
    http://localhost:8080/v1/auth/register
    METHOD: POST
    
        {
          "username": "string",
          "password": "string",
          "fullName": "string",
          "address": "string",
          "publisher": boolean,
        }
```

##### <a id="login"> Login for User and Admin

```
      http://localhost:8080/v1/auth/login
      METHOD:POST
    
       {
         "username": "string",
         "password": "string"
       }
```

## Garment service

##### <a id="publish"> Publish garment

``` 
    http://localhost:8080/v1/garment
    Method: POST
    Authentication: Bearer Token
    
        {
          "type": "string",
          "description": "string",
          "price": double,
          "size": "string",
        }
```

##### <a id="delete"> Delete garment

```
      http://localhost:8080/v1/garment/{garmentId}
      METHOD: DELETE
      Authentication: Bearer Token
```

##### <a id="put"> Update garment

```
      http://localhost:8080/v1/garment/{garmentId}
      METHOD: PUT
      Authentication: Bearer Token
      
      {
          "type": "string",
          "description": "string",
          "price": double,
          "size": "string",
        }
```

## Clothes service

##### <a id="getClothes"> Get all garments

```
      http://localhost:8080/v1/clothes
      METHOD: GET
      
```

##### <a id="getClothes"> Get detailed garment

```
      http://localhost:8080/v1/clothes/{garmentId}
      METHOD: GET
      
```