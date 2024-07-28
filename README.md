# SIS Consumer

- A software to manage bars and shops. It will be a software with the objective of helping waiters and employees at the time of movement and will calculate inputs and outputs of products.


## Compile project to jar
	
- mvn compile exec:java


## Create a exe file linux 

- mvn package

- jpackage --input target/ \
         --name SisConsumer \
         --main-jar sis-consumer-1.0-SNAPSHOT.jar \
         --main-class com.mycompany.sis.consumer.SisConsumer \
         --type app-image

## About Project

- In [entre aqui](about)
