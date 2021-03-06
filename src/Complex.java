
public class Complex {
    private double real, imag;

    Complex() {
        this.real = 0;
        this.imag = 0;
    }

    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal() {
        return (imag == 0);
    }

    public boolean isImaginary() {
        return (real == 0);
    }

    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }

    public boolean equals(Complex Complex) {
        return (this.real == Complex.real && this.imag == Complex.imag);
    }

    public static boolean equals(Complex thatOther, Complex that) {
        return (that.real == thatOther.real && that.imag == thatOther.imag);
    }

    public double magnitude() {
        return Math.hypot(real, imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public static Complex add(Complex thatOther, Complex that) {
        return new Complex(thatOther.real + that.real, thatOther.imag + that.imag);
    }

    public Complex add(Complex that) {
        return new Complex(this.real + that.real, this.imag + that.imag);
    }

    public static Complex subtract(Complex that, Complex thatOther) {
        return new Complex(that.real - thatOther.real, that.imag - thatOther.real);
    }

    public Complex subtract(Complex that) {
        return new Complex(this.real - that.real, this.imag - that.imag);
    }

    public static Complex multiply(Complex that, Complex thatOther) {
        return new Complex(((thatOther.real * that.real) - (thatOther.imag * that.imag)),
                ((thatOther.real * that.imag) + (thatOther.imag + that.real)));
    }

    public Complex multiply(Complex b) {
        Complex a = this;
        double real = a.real * b.real - a.imag* b.imag;
        double imag = a.real * b.imag + a.imag * b.real;
        return new Complex(real, imag);
    }

    public static Complex divide(Complex that, Complex thatOther) {
        Complex instance = multiply(that, thatOther.conjugate());
        double denominator = (Math.pow(thatOther.real, 2) + Math.pow(thatOther.imag, 2));
        return new Complex(instance.real / denominator, instance.imag / denominator);
    }

    public Complex conjugate() {
        return new Complex(this.real, -this.imag);
    }

    public Complex square() {
        return multiply(this);
    }
}