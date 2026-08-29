package software.aoc.day10.b;

import java.math.BigInteger;

/** Fracción exacta reducida, usada para evitar errores de precisión en la eliminación gaussiana. */
final class Rational {
    static final Rational ZERO = new Rational(BigInteger.ZERO, BigInteger.ONE);
    static final Rational ONE = new Rational(BigInteger.ONE, BigInteger.ONE);

    final BigInteger num;
    final BigInteger den;

    Rational(BigInteger num, BigInteger den) {
        if (den.signum() == 0) throw new ArithmeticException("División por cero");
        if (den.signum() < 0) { num = num.negate(); den = den.negate(); }
        BigInteger g = num.gcd(den);
        if (g.signum() != 0) { num = num.divide(g); den = den.divide(g); }
        this.num = num;
        this.den = den;
    }

    static Rational of(long v) { return new Rational(BigInteger.valueOf(v), BigInteger.ONE); }

    Rational add(Rational o) { return new Rational(num.multiply(o.den).add(o.num.multiply(den)), den.multiply(o.den)); }
    Rational sub(Rational o) { return new Rational(num.multiply(o.den).subtract(o.num.multiply(den)), den.multiply(o.den)); }
    Rational mul(Rational o) { return new Rational(num.multiply(o.num), den.multiply(o.den)); }
    Rational div(Rational o) { return new Rational(num.multiply(o.den), den.multiply(o.num)); }

    boolean isZero() { return num.signum() == 0; }
    int signum() { return num.signum(); }
    boolean isInteger() { return den.equals(BigInteger.ONE); }
    BigInteger toBigIntegerExact() {
        if (!isInteger()) throw new ArithmeticException("Valor no entero: " + this);
        return num;
    }
    int compareTo(Rational o) { return num.multiply(o.den).compareTo(o.num.multiply(den)); }

    @Override public String toString() { return isInteger() ? num.toString() : num + "/" + den; }
}