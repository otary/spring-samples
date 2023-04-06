@echo off


start cmd /k "cd spring-cloud-basic-eureka\spring-cloud-basic-eureka-server & mvn spring-boot:run"
start cmd /k "cd spring-cloud-basic-eureka\spring-cloud-basic-eureka-client & mvn spring-boot:run"
start cmd /k "cd spring-cloud-basic-discovery\spring-cloud-basic-ribbon & mvn spring-boot:run"
start cmd /k "cd spring-cloud-basic-discovery\spring-cloud-basic-feign & mvn spring-boot:run"
start cmd /k "cd spring-cloud-basic-zuul & mvn spring-boot:run"
