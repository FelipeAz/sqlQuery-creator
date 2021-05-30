# sqlQuery-creator

sqlQuery-creator is a command line application which transforms a JSON file into a SQL Query. This project have been built using the concept of ``Domain`` from Domain Driven Design (DDD). A domain represents a ``context`` on the application and it's functionality is only related to it's context.

### Dependencies

This project was built using Maven to manage the application dependencies. The dependency used on this project is ``com.googlecode.json-simple`` to manipulate JSON data.

### Directories

| Dir |Content|
| --- | --- |
| src | Application folder |
| domain | Contains the application modules which were divided in two items: Json and Query  |
| Json | Contains every action that is related to the JSON file |
| Query | Contains every action that is responsible to the Query Creation |
| Utils | Functions that can be util to the current module. |
| Service | Contains the domain's logic.  |
| Entity | Contains information about a domain item |
| Exception | Represents domain's exceptions |
| Main | Contains the application main file |


### JSON Example

````
{
"columns":[
    {
        "operator":"Between",
        "fieldName":"Age",
        "fieldValue":[
            "25",
            "30"
        ]
    },
    {
        "operator":"Equal",
        "fieldName":"Role",
        "fieldValue":[
            "Software Engineer"
        ]
    },
    {
        "operator":"GreaterThanOrEqual",
        "fieldName":"Salary",
        "fieldValue":[
          "99999.99"
        ]
    },
    {
        "operator":"Like",
        "fieldName":"Name",
        "fieldValue":[
            "a"
        ]
    }
  ]
}
````
