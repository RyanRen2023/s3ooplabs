#!/bin/bash

# Stop and remove the existing MySQL container
docker stop mysql
docker rm mysql

# Create a new MySQL container with environment variables to initialize the database
docker create --name mysql \
    -e MYSQL_DATABASE=lab2 \
    -e MYSQL_ROOT_PASSWORD=Root \
    -e MYSQL_USER=username \
    -e MYSQL_PASSWORD=password \
    -p 3306:3306 \
    mysql:latest

# Create Docker network (if not already created)
docker network rm app
docker network create app

# Connect the MySQL container to the Docker network
docker network connect app mysql

# Update restart policy to always restart the container
docker update --restart=always mysql

# Start the MySQL container
docker start mysql

echo "MySQL container setup complete."
