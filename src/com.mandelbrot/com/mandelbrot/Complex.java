package com.mandelbrot;
import java.awt.*;

public class Complex {
    public double startReal;
    public double startImaginary;
    public double real=0;
    public double imaginary=0;
    public int iterated =0;
    Complex(double r, double i){
        real=r;
        startReal=r;
        imaginary=i;
        startImaginary=i;
    }
    public static Complex mandelbrot(Complex prev){
         Complex mandy = square(prev);
         mandy.iterated++;
         return mandy;
    }
    public static Complex square (Complex input){
        double real=Math.pow(input.real,2)-Math.pow(input.imaginary,2);
        double imaginary=2*input.real*input.imaginary;
        return new Complex(real,imaginary);
    }
    public static Complex complexify(Point point){

        return new Complex(point.x,point.y);
    }
}