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
            "position": "Mid Laner"
        },
        {
            "id": 2,
            "name": "Tony Stark",
            "position": "Top Laner"
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
        "position": "Mid Laner"
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
        "position": "Mid Laner"
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
        "position": "Mid Laner"
    }
}
```
