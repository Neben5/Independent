import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class CalcBroker {
    private Consumer<int[][]> outConsumer;
    private int[][] outs;
    private IntSupplier height, width;
    Calculator[] calculators;
    private double zoom;
    private double leftStart;
    private double rightStart;

    public CalcBroker(Consumer<int[][]> outConsumer, IntSupplier height, IntSupplier width) {
        this.outConsumer = outConsumer;
        this.height = height;
        this.width = width;
    }

    // calculator for every column
    public void rePlot(double[] args) {
        zoom = args[0];
        leftStart = args[1];
        rightStart = args[2];
        calculators = new Calculator[width.getAsInt()];
        for (int x = 0; x < calculators.length; x++) {
            Mandy[] comps = new Mandy[height.getAsInt()];
            for (int y = 0; y < height.getAsInt(); y++) {
                double reel = -zoom / leftStart + (zoom / (double) width.getAsInt()) * (double) x;
                double imag = -zoom / rightStart + (zoom / (double) height.getAsInt()) * (double) y;
                comps[y] = new Mandy(reel, imag);
            }
            calculators[x] = new Calculator(comps);
        }
    }

    public void run() {
        for (Calculator c : calculators) {
            c.run();
        }
        for (int i = 0; i < calculators.length; i++) {
            try {
                calculators[i].join();
                outs[i] = calculators[i].getOuts();
            } catch (Exception e) {

            }
        }
        outConsumer.accept(outs);
    }
}
