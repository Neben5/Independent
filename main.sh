javac -d ./build src/com.Mandelbrot/*.java
jar cmvf META-INF/MANIFEST.mf ./build/mandelbrot.jar ./build/mandelbrot/*
java -jar ./build/mandelbrot.jar