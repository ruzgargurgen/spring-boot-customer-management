# spring-boot-customer-management

SignUp

POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8181
Content-Type: application/json
Content-Length: 75

{ 
    "name":"admin",
    "username":"admin",
    "password":"admin"
}

MakeAdmin

PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8181
Authorization: Bearer InternalApiKey1234!

SignIn

POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8181
Content-Type: application/json
Content-Length: 53

{
    "username":"admin",
    "password":"admin"
}

GetAllUsers

GET /api/authentication HTTP/1.1
Host: localhost:8181

CreateCustomer

POST /api/customer HTTP/1.1
Host: localhost:8181
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9
.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjUyODk0MTU2fQ
.oH0czbp8C42Fwi3q0zd_4Af9VgTOBZZPH50sO6NIlyzX5d8qNiaxdE1xt1BsyPI5HrYXaOIW9EcS3-9x8Dz4WA
Content-Type: application/json
Content-Length: 170

{
    "firstname":"customer1",
    "lastname":"customer1",
    "gender":"MALE",
    "address":"istanbul",
    "email":"customer1@gmail.com",
    "phone":"177812"
}

GetAllCustomer

GET /api/customer HTTP/1.1
Host: localhost:8181

GetByFirtNameCustomer

GET /api/customer/customer1 HTTP/1.1
Host: localhost:8181

UpdateCustomer

PUT /api/customer/1 HTTP/1.1
Host: localhost:8181
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9
.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjUyODk0MTU2fQ
.oH0czbp8C42Fwi3q0zd_4Af9VgTOBZZPH50sO6NIlyzX5d8qNiaxdE1xt1BsyPI5HrYXaOIW9EcS3-9x8Dz4WA
Content-Type: application/json
Content-Length: 169

{
     "firstname":"customer",
    "lastname":"customer",
    "gender":"MALE",
    "address":"istanbul",
    "email":"customer@gmail.com",
    "phone":"17782"
}

DeleteCustomer

DELETE /api/customer/1 HTTP/1.1
Host: localhost:8181
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9
.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjUyODk0MTU2fQ
.oH0czbp8C42Fwi3q0zd_4Af9VgTOBZZPH50sO6NIlyzX5d8qNiaxdE1xt1BsyPI5HrYXaOIW9EcS3-9x8Dz4WA
