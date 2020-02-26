public class Mandy{
    private int iterations = 0;
    private Complex current = new Complex();
    private Complex mine;
    Mandy(double r, double i){
        mine = new Complex(r,i);
        current = current.square().add(mine);
        iterations++;
    }
    public int calculate(){
        if(current.magnitude()>=2.){
            iterations=254;
        }if(current.magnitude()==0){
            iterations=0;
        }else{
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