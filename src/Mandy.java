public class Mandy{
    private int iterations = 0;
    private Complex current = new Complex();
    public Complex mine;
    Mandy(double r, double i){
        mine = new Complex(r,i);
    }
    public int calculate(){
        while(current.magnitude()<=2. && iterations<255){ //if for fade
            current = current.square().add(mine);
            iterations++;
        }
        return iterations;
    }
    @Override
    public String toString() {
        return current.toString();
    }
}