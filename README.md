# Spring Boot REST API Starter Template

Sample Response:

*GET http://localhost:8080/api/v1/employees*

```javascript
{
    "code": 200,
    "message": "success",
    "result": [
        {
            "id": 1,
            "name": "Ipan Ardian",
            "position": "VP Engineer"
        },
        {
            "id": 2,
            "name": "Tony Stark",
            "position": "Java Developer"
        }
    ]
}
```

*POST http://localhost:8080/api/v1/employees*
```javascript
{
    "code": 200,
    "message": "success",
    "result": {
        "id": 5,
        "name": "Ipan Ardian",
        "position": "VP Engineer"
    }
}
```

*PUT http://localhost:8080/api/v1/employees/{id}*
```javascript
{
    "code": 200,
    "message": "success",
    "result": {
        "id": 5,
        "name": "Ipan Ardian",
        "position": "VP Engineer"
    }
}
```

*DELETE http://localhost:8080/api/v1/employees/{id}*
```javascript
{
    "code": 200,
    "message": "Employee deleted successfully",
    "result": {
        "id": 5,
        "name": "Ipan Ardian",
        "position": "VP Engineer"
    }
}
```
