package com.mandelbrot;
import java.awt.*;

public class Complex {
    public double real=0;
    public double imaginary=0;
    public int iterated =0;
    Complex(double r, double i){
        real=r;
        imaginary=i;
    }
    public static Complex mandelbrot(Complex prev, Complex point){
         Complex mandy = sum(square(prev), point);
         mandy.iterated=prev.iterated+1;
         return mandy;
    }
    public static Complex square (Complex input){
        double real=Math.pow(input.real,2)-Math.pow(input.imaginary,2);
        double imaginary=2*input.real*input.imaginary;
        return new Complex(real,imaginary);
    }
    public static Complex sum(Complex a, Complex b){
        return new Complex(a.real+b.real,a.imaginary+b.imaginary);
    }
    public static Complex complexify(Point point){
        return new Complex(point.x,point.y);
    }
}