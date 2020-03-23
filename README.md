# 01-assignment-quarkus-jpa-ThomasAnt

# Deployment

+ start postgres in docker
  + docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=passme postgres
+ start quarkus application
  + mvn compile quarkus:dev
  + mvn quarkus:dev
  + oder in der IDE

# ERD
![ERD](graveyard.png)
