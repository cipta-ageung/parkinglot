#!/bin/sh

./mvn clean install 

./mvnw -Dmaven.test.skip=true
