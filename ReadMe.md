

mvn clean install
mvn spring-boot:run

http://localhost:8080/swagger-ui/index.html
http://localhost:8080/v3/api-docs

# Method Get
http://localhost:8080/entities/non-blocking

http://localhost:8080/entities/12345

# Method: put
URL: http://localhost:8080/entities/12345

{  
  "name": "Updated Entity Name",
  "description": "Updated description of the entity"
}


# mongo db docker
docker run -d --name mongo -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin123 -p 27017:27017 mongo
docker exec -it  mongo bash   #run mongo

use admin;
db.createUser({
  user: "testUser",
  pwd: "testUser",
  roles: [{ role: "dbAdmin", db: "test" },
  { role: "readWrite", db: "admin" } ]
})


# Mongo login
use test;
db.auth("testUser", passwordPrompt()) ;

# curl
curl -X PUT http://localhost:8080/entities/123 \
-H "Content-Type: application/json" \
-d '{"name":"Test Entity", "description":"This is a test entity."}'