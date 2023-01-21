#!/bin/bash

git pull
mvn package
rm MegaBot-1.0.jar
mv target/MegaBot-1.0.jar MegaBot-1.0.jar
java -jar MegaBot-1.0.jar