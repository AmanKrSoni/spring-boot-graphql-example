# Spring Boot + GraphQl 

### Examples
* Api is exposed at http://localhost:8080 [POST, GET]

## Graphql Endpoints : [here](http://localhost:8080/graphiql)
GraphQl Querry
### 
* Create Vehicle by GraphQl Mutation
```$xslt
mutation{
  createVehicle(type:"BUS", model : "Mahindra-BUS", brandName :"Mahindra", launchDate:"2021-02-09"){
    id , model, brandName, type, launchDate
  }
}
```
* Get Vehicle by id
```$xslt
query{
  vehicle(id: 2){
    id, model, launchDate
  }
}
```
* Get Vehicles by Model name
```$xslt
query{
  getVehiclesByModel(model: "Model-Name"){
    id, model, launchDate, brandName // this are the attributes which we want to fetch
  }
}
```


-----------

For Entity Employee Which is Nested examples when have parent child relation within the entity

* Create An Employee using graphql playground
```$xslt
mutation createEmployee($input: Employee!){
  createEmployee(input : $input){
    id
    name{
      firstName
      middleName
      lastName
    }
    address{
      country
      state
      city
      zipCode
    }
    position
  }
}
```
In the Query variable Tab use below json 
```json
{
  "input" : {
    "id": 1,
    "name" : {
    "firstName" : "Name",
    "middleName" : "Moddle Name",
    "lastName" : "LastName"
  },
  
  "address" : {
   "country": "Country",
    "state" : "State",
    "city" : "city",
    "zipCode" : "ZipCode"
  },
  
  "position": "Position"
    
  }
}
```
---
## Subscription
* Subscribe for the event
```graphql
subscription{
  employees{
    id
    name{
      firstName
      middleName
      lastName
    }
    address{
      country
      state
      city
      zipCode
    }
    position
  }
}
```
