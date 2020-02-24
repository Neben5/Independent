javac -d ./build src/*.java
java -cp ./build MainFrame
#jar cmvf ./build/mandelbrot.jar -ea .build/MainFrame.class ./build/*
#java -jar ./build/mandelbrot.jar