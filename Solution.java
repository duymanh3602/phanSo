public class Solution {

    private int numerator; // tử
    private int denominator; // mẫu

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    /**
     * he.
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * he.
     */
    Solution() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * he.
     */
    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }

    /**
     * he.
     */
    public Solution reduce() {
        Solution temp = new Solution();
        temp.denominator = this.denominator;
        temp.numerator = this.numerator;
        int index = 9;
        while (index > 1) {
            while (temp.numerator % index == 0 && temp.denominator % index == 0) {
                temp.numerator /= index;
                temp.denominator /= index;
            }
            index--;
        }
        return temp;
    }

    /**
     * he.
     */
    public Solution add(Solution other) {
        Solution temp = new Solution();
        temp.setNumerator(this.numerator * other.getDenominator()
                + this.denominator * other.getNumerator());
        temp.setDenominator(this.denominator * other.getDenominator());
        temp.reduce();
        return temp;
    }

    /**
     * he.
     */
    public Solution subtract(Solution other) {
        Solution temp = new Solution();
        temp.setNumerator(this.numerator * other.getDenominator()
                - this.denominator * other.getNumerator());
        temp.setDenominator(this.denominator * other.getDenominator());
        temp.reduce();
        return temp;
    }

    /**
     * he.
     */
    public Solution multiply(Solution other) {
        Solution temp = new Solution();
        temp.setNumerator(this.numerator * other.getNumerator());
        temp.setDenominator(this.denominator * other.getDenominator());
        temp.reduce();
        return temp;
    }

    /**
     * he.
     */
    public Solution divide(Solution other) {
        Solution temp = new Solution(this.numerator, this.denominator);
        if (other.getDenominator() != 0 && other.getNumerator() != 0) {
            temp.setNumerator(this.numerator * other.getDenominator());
            temp.setDenominator(this.denominator * other.getNumerator());
            temp.reduce();
        }
        return temp;
    }

    /**
     * he.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            other = other.reduce();
            Solution temp = new Solution();
            temp.setNumerator(this.numerator);
            temp.setDenominator(this.denominator);
            temp = temp.reduce();
            if (temp.getDenominator() == other.getDenominator()
                    && temp.getNumerator() == other.getNumerator()) {
                return true;
            }
        }
        return false;
    }
    public void printPS() {

        System.out.println(this.numerator+"/"+this.denominator);
    }
}
