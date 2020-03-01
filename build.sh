#!/bin/sh
javac -d ./build src/*.java
cd build
jar cfm ./app/Mandy.jar ../META-INF/MANIFEST.MF *.class
java -jar ./app/Mandy.jar