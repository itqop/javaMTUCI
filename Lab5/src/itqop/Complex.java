package itqop;

public class Complex {

    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double real() {
        return real;
    }

    public double imag() {
        return imag;
    }

    public void real(double real) {
        this.real = real;
    }

    public void imag(double imag) {
        this.imag = imag;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imag + c.imag);
    }

    public Complex multiply(Complex c) {
        return new Complex(real * c.real - imag * c.imag, real * c.imag + imag * c.real);
    }

    public Complex divide(double n) {
        return new Complex(real / n, imag / n);
    }

    public double getMagnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    @Override
    public String toString() {
        return formatOutput(real) + ", " + formatOutput(imag) + " i";
    }

    private String formatOutput(double output) {
        if (Math.abs(output) > 1.0 / 16.0) return String.valueOf(output);
        return String.format("%.2e", output);
    }
}
