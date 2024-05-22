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