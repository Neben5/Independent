public class Calculator extends Thread {
    private Mandy[] comps;
    private int[] outs;

    @Override
    public void run() {
        for (int i = 0; i < comps.length; i++) {
            outs[i] = comps[i].calculate();
        }
    }

    Calculator(Mandy[] comps) {
        this.comps = comps;
    }

    public int[] getOuts() {
        return outs;
    }
}
