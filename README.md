# Greek-Vaccination-Monitor

## For the back-end:
Database: MySQL

Implemented the above:

- Return the population of a given region
```
GET: http://localhost:8080/region/find/population/{id}
```


- Return a list of total vaccinations per day, for a given region
```
GET: http://localhost:8080/region/find/dates/{id}
```


- Return the percentage of the population that has been vaccinated per region, for all regions
```
GET: http://localhost:8080/region/all
```

## For the front-end:
In the directory ```vacsmonitorApp```:
```
ng serve
```
