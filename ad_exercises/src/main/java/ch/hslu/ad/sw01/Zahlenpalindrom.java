package ch.hslu.ad.sw01;

public class Zahlenpalindrom {

    public static void main(String[] args) {
        System.out.println(isSymmetric(1001001001));
        System.out.println(nextSymmetric(0));
    }

    /**
     * Checks if number is symmetric. The method is to reverse the entered integer and to compare it the reversed with the original one.
     * @param n the number to be checked
     * @return true if the number is symmetric, false if it is not
     */
    public static boolean isSymmetric(int n) {
        int reverse = 0;
        int temp = n;

        if (n < 10) return true;

        while (temp != 0) {
            int remainder = temp % 10;
            reverse = reverse * 10 + remainder;
            temp = temp / 10;
        }

        return n == reverse;
    }

    /**
     * Finds the next symmetric number after the one entered.
     * @param n the number to start searching from
     * @return the next symmetric number
     */
    public static int nextSymmetric(int n) {
        while (!isSymmetric(n)){
            n++;
        }
        return n;
    }

}
