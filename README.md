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