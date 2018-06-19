# WeLearn-be
WeLearn-be is WeLearn-FE's backend and exposes some REST API for performing some operations and accessing to the data.
**WARNING**: It's not recommended to put it in production because it is not ready yet. There are many security and functionality issues.
## Requirements
It requires ```docker```, ```keycloak```, ```mongodb``` and ```nuvola-magica```.
## Keycloak setup
* Create a REALM
* Create the role TEACHER
* Add some users.
* Create a client welearn-be with:
  * Access type = 'bearer-only'
  * Copy the secret in the credentials tab
## Configuration of the project
There is a configuration file called ```application.properties``` in ```src/main/resources/```. It should be configured accordingly your needs. The passwords should be changed.
In particular set the correct values to the ```keycloak.auth-server-url```, ```spring.data.mongodb.uri``` and ```nuvola-magica.base_url``` properties.
## Setup (on docker)
```bash
git clone https://github.com/Marconi-weLearn/weLearn-be.git
cd weLearn-be
mvn package
docker build -t welearn-be:latest .
docker run -dp 8081:8080 --name welearn-be welearn-be:latest
```
