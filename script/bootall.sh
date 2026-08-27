#!/bin/bash

echo "Iniciando os projetos spring-boot"

mvn spring-boot:run -f ../conversao-ativa/pom.xml &

mvn spring-boot:run -f ../conversao-corrente/pom.xml &

mvn spring-boot:run -f ../naming-service/pom.xml &

mvn spring-boot:run -f ../apigateway/pom.xml &

wait
