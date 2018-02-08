package edu.cpp.austin.CS301_Homework4;

public class Main {

    public static void main(String[] args) {
        test_coef_eval();
    }

    public static double[] coef(int n, double[] x, double[] y) {
        int i, j;
        double[] a = new double[n];
        for (i = 0; i < n; i++) {
            a[i] = y[i];
        }
        for (j = 1; j < n; j++) {
            for (i = n - 1; i > j; i--) {
                a[i] = (a[i] - a[i - 1]) / (x[i] - x[i - j]);
            }
        }
        return a;
    }

    public static double eval(int n, double[] x, double[] a, double t) {
        double temp = a[n - 1];
        for (int i = n - 2; i > 0; i--) {
            temp = temp * (t - x[i]) + a[i];
        }
        return temp;
    }

    public static void test_coef_eval() {
        int j_max = 0;
        double e, p, t, p_max = 0, t_max = 0;

        int n = 9;
        double h = 1.6875 / n;
        double[] x = new double[n];
        double[] y = new double[n];


        for (int k = 0; k < n; k++) {
            x[k] = k * h;
            y[k] = Math.sin(x[k]);
        }
        double[] a = coef(n, x, y);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        double e_max = 0;

        for (int j = 0; j < 4 * n; j++) {
            t = j * h / 4.0;
            p = eval(n, x, a, t);
            e = Math.abs(Math.sin(t) - p);
            System.out.println("j: " + j);
            System.out.println("t: " + t);
            System.out.println("p: " + p);
            System.out.println("e: " + e);

            if (e > e_max) {
                j_max = j;
                t_max = t;
                p_max = p;
                e_max = e;
            }
        }

        System.out.println("j_max: " + j_max);
        System.out.println("t_max: " + t_max);
        System.out.println("p_max: " + p_max);
        System.out.println("e_max: " + e_max);

    }
}
