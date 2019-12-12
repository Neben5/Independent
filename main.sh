javac -d ./build src/com.mandelbrot/com.mandelbrot/*.java
jar cmvf META-INF/MANIFEST.mf ./build/mandelbrot.jar ./build/mandelbrot/*
java -jar ./build/mandelbrot.jar