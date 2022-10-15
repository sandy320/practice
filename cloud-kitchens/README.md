##### **Kitchen System**

This application is a real-time system  that simulates the fulfillment of delivery orders for a kitchen.
It could be run in both cmd and IDE.

###### **Running environment**

Java 1.8

****Configuration
**strategy**
    The strategy full class name 
    should be com.kitchen.strategy.MatchedPickStrategy
           or com.kitchen.strategy.FifoPickStrategy
    Default is com.kitchen.strategy.FifoPickStrategy

**data.file**
    The json data file full path name
    Default is /dispatch_orders.json

**order.cnt.persecond**
    The order count which kitchen received per second
    Default is 2

**courier.earliest**
    The courier arrived earliest time in second
    Default is 3

**courier.latest**
    The courier arrived latest time in second
    Default is 15

###### **Running in IDE**

The config file application.properties is located at resources folder
The settings is as below:

strategy=com.kitchen.strategy.FifoPickStrategy
data.file=d:/dispatch_orders.json
order.cnt.persecond=3
courier.earliest=4
courier.latest=12

###### **Running in CMD**

This app could also run in cmd with jar file 

**Jar**
    cloud-kitchens-1.0-SNAPSHOT-jar-with-dependencies.jar

**main class**
    com.kitchen.Application

**args**
    args[0] strategy
    args[1] data.file
    args[2] order.cnt.persecond
    args[3] courier.earliest
    args[4] courier.latest

**CMD**
java -cp cloud-kitchens-1.0-SNAPSHOT-jar-with-dependencies.jar com.kitchen.Application com.kitchen.strategy.FIFOPickStrategy d:/dispatch_orders.json 2 4 14

###### **Statistics**

After the system finish, the statistics will be print in console