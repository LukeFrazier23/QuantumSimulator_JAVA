public class complexNum {

    private double real;
    private double imag;

    // Default constructor 
    public complexNum() {
        this.real = 0;
        this.imag = 0;
    }

    // Constructor R/C parts
    public complexNum(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // copy constructor
    public complexNum(complexNum other) {
        this.real = other.real;
        this.imag = other.imag;
    }

    //getters
    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    // setters
    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    // Add
    public complexNum add(complexNum other) {
        return new complexNum(this.real + other.real, this.imag + other.imag);
    }

    // Subtract
    public complexNum subtract(complexNum other) {
        return new complexNum(this.real - other.real, this.imag - other.imag);
    }

    // Multiply
    public complexNum multiply(complexNum other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new complexNum(r, i);
    }

    // Divide
    public complexNum divide(complexNum other) {
        double denominator = other.real * other.real + other.imag * other.imag;

        double r = (this.real * other.real + this.imag * other.imag) / denominator;
        double i = (this.imag * other.real - this.real * other.imag) / denominator;

        return new complexNum(r, i);
    }

    // Magnitude
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // Conjugate
    public complexNum conjugate() {
        return new complexNum(real, -imag);
    }

    // Equals
    public boolean equals(complexNum other) {
        return this.real == other.real && this.imag == other.imag;
    }

    // toString
    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + Math.abs(imag) + "i";
        }
    }
}
