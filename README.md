# Meet up Parser
[![](https://img.shields.io/badge/Spring%20Boot%20Version-3.2.5-blue)](/pom.xml)
[![](https://img.shields.io/badge/Java%20Version-21-blue)](/pom.xml)
<br>
🌱 This app has been created with the purpose of transforming data from a format like this...
<br>
```json
{
  "input": [
    {
      "edition": "4th",
      "name": "JBCN Conference",
      "startDate": "2018-06-11",
      "endDate": "2018-06-13",
      "location": [
        {
          "city": "Barcelona",
          "country": "Spain"
        }
      ]
    },
    {
      "edition": "3rd",
      "name": "DevTernity",
      "startDate": "2018-11-30",
      "endDate": "2018-12-01",
      "location": [
        {
          "city": "Riga",
          "country": "Latvia"
        }
      ]
    }
  ]
}
```

⚡ to this...
<br>
```json
{
  "meetUps": [
    "4th JBCN Conference · 2018-06-11 / 2018-06-13 · Barcelona, Spain",
    "3rd DevTernity · 2018-11-30 / 2018-12-01 · Riga, Latvia",
    "1st I T.A.K.E Unconference · 2016-05-19 / 2016-05-20 · Bucharest | Maramures, Romania",
    "2nd Product Owner Rule Book · 2016-04-11 / 2016-04-13 · Paris, France | Madrid, Spain",
    "Upfront Summit · 2018-02-01 · Los Angeles, California. United States",
    "IBM Think · 2018-03-19 · Nevada, United States"
  ]
}
```

There is only one endpoint but hey, if in the future there are any more you can check them out [here](http://localhost:8080/swagger-ui/index.html) after running the app!

There is still a lot of room for improvement (of course 😁), for instance we could change the way the service ended up being so clustered in some methods, make sure the methods have single responsibility and make the code more readable.

Decided to work only with _records_ since all data is final and makes it more readable, concise and immutable.

As for the problem to resolve, I decided to create an endpoint that accepts data under some constraints:
* The opening object is a list of meetups and must have the name of *input* as in the example provided.
* If there are no elements in the array, it will return an error with status 400.

Still many more controls to add on the code, but does the work and provides a result exact to the example provided.

There is only one controller and one service. The controller offers the endpoint and expects the body to contains a JSON with the same format as shown above.
The service has all the logic and pretty much handles all the data transformation.

Decided to use StringBuilder to manage and append all the data in one single and long string per meet up, and then add the result of this string into an array to be returned.