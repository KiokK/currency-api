# Technologies
- Spring 5
- Spring-security 5
- PostgreSql
- Tomcat 9.0.74
- Mapstruct
- hibernate-validator (only for dto validation)
- springfox-swagger2

## How to run

- Only Postgresql and PgAdmin containers [docker-compose.yaml](docker-compose.yaml)
- DB:
  1. [schema.sql](src%2Fmain%2Fresources%2Fdb%2Fddl%2Fschema.sql)
  2. [data.sql](src%2Fmain%2Fresources%2Fdb%2Fdml%2Fdata.sql)


### Swagger 

http://localhost:8080/api/swagger-ui.html#/
