# sqlQuery-creator

sqlQuery-creator is a command line application which transforms a JSON file into a SQL Query.

### Dependencies

JDK version 16+

Maven is required to run this project. You can install it using the following command:

``apt install maven``

This project was built using Maven to manage the application dependencies. The dependency used on this project was ``com.googlecode.json-simple`` to manipulate JSON data.

### Instructions

To run this application, make sure you have installed maven on your computer, if so, follow the commands bellow:

``make install`` - install the application and download the dependencies using maven

``make run`` - initialize the application

### Directories

| Dir |Content|
| --- | --- |
| src2 | Application folder |
| app.domain | Contains the application modules which were divided in two items: Json and Query  |
| Json | Every action that is related to read the JSON file |
| Query | Every action that is responsible to the Query Creation |
| Utils | Functions that can be util to the current module. |
| Service | Contains the app.domain's logic.  |
| Entity | Contains information about a app.domain item |
| Exception | Represents app.domain's exceptions |
| app.main.Main | The application main file |


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