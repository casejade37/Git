package lectures.resources.lesson1;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int initialNumerator, int initialDenominator) {
        numerator = initialNumerator;
        denominator = initialDenominator;
    }

    //Add getters and setters
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }


    //Add toFloat
    public float toFloat() {
        return numerator / (float) denominator;
    }

    //Add Multiplication
    // NOTE INSTANCE VS CLASS
    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(f1.getNumerator() * f2.getNumerator(),
                f1.getDenominator() * f2.getDenominator());
    }

    // What about another constructor

    // Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Fraction)) {
            return false;
        }

        Fraction other = (Fraction) obj;

        return this.denominator == other.denominator && this.numerator == other.numerator;
    }
}
