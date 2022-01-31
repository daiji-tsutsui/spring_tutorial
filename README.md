# Simple CRUD App with spring

## Database setting

Make a file `src/main/resources/application.yml` like as [application.yml.sample](./src/main/resources/application.yml.sample)

Create your database described in `application.yml` above.
```
$ createdb ${your database}
```

Migrate schemas to your database.
```
$ psql ${your database} < src/main/resources/schema.sql
```

## Execute

Run
```
$ gradle bootRun
```
if you have installed `gradle`, or you also can run
```
$ ./gradlew bootRun
```