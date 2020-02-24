#!/bin/sh
javac -d ./build src/*.java
./run.sh
#jar cmvf ./build/mandelbrot.jar -ea .build/MainFrame.class ./build/*
#java -jar ./build/mandelbrot.jar