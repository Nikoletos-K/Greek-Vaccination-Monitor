# Greek-Vaccination-Monitor

## For the back-end:
- Made with Spring boot (may need to change password in file ``` application.properties ```)
- Database: MySQL
- Directory: ```vaccsmonitorsql```

#### Requests implemented

1. Return the population of a given region
```
GET: http://localhost:8080/region/find/population/{id}
```


2. Return a list of total vaccinations per day, for a given region
```
GET: http://localhost:8080/region/find/dates/{id}
```


3. Return the percentage of the population that has been vaccinated per region, for all regions
```
GET: http://localhost:8080/region/all
```

#### Data
Given .csv files are in the directory:
```
.\vaccsmonitorsql\data
```

## For the front-end:
- Made with Angular
- Directory ```vacsmonitorApp```

Initializing Angular:
```
ng serve
```
Open browser to:
```
http://localhost:4200/
```

