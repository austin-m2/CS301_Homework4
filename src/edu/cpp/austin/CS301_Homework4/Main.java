//CS301 Homework 4
//Austin Morris

package edu.cpp.austin.CS301_Homework4;

public class Main {

    public static void main(String[] args) {
        test_coef_eval();
        opening_problem();
        exercise_4_2_1();
        exercise_4_2_2();
    }

    public static double[] coef(int n, double[] x, double[] y) {
        int i, j;
        double[] a = new double[n];
        for (i = 0; i < n; i++) {
            a[i] = y[i];
        }
        for (j = 1; j < n; j++) {
            for (i = n - 1; i >= j; i--) {
                a[i] = (a[i] - a[i - 1]) / (x[i] - x[i - j]);
            }
        }
        return a;
    }

    public static double eval(int n, double[] x, double[] a, double t) {
        double temp = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            temp = temp * (t - x[i]) + a[i];
        }
        return temp;
    }



    public static void test_coef_eval() {
        System.out.println("Example 8");
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

        System.out.println("Coefficients:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        double e_max = 0;

        for (int j = 0; j < 4 * n; j++) {
            t = (j * h) / 4.0;
            p = eval(n, x, a, t);
            e = Math.abs(Math.sin(t) - p);
            System.out.println("\nj: " + j);
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

        System.out.println("\nj_max: " + j_max);
        System.out.println("t_max: " + t_max);
        System.out.println("p_max: " + p_max);
        System.out.println("e_max: " + e_max);

    }

    private static void opening_problem() {
        System.out.println("\nOpening problem of ch. 4:");
        int n = 4;
        double[] x = {0, 5, 10, 15};
        double[] y = {1.792, 1.519, 1.308, 1.140};
        double[] a = coef(n, x, y);

        System.out.println("Coefficients:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        double result = eval(n, x, a, 8);
        System.out.print("Value of f(8): " + result);
    }

    private static void exercise_4_2_1() {
        System.out.println("\n\nExercise 4.2 #1");
        double[] x = new double[21];
        double[] y = new double[21];
        for (int i = 0; i < x.length; i++) {
            x[i] = -5.0 + (i * 0.5);
            y[i] = Math.pow(Math.pow(x[i], 2) + 1, -1);
        }
        double[] a = coef(21, x, y);

        for (int i = 0; i < 41; i++) {
            double node = -5 + (i * .25);
            System.out.println("\nNode: " + node);
            System.out.println("f(" + node + "): " + Math.pow(Math.pow(node, 2) + 1, -1));
            System.out.println("p(" + node + "): " + eval(21, x, a, node));
        }
    }

    private static void exercise_4_2_2() {
        System.out.println("\n\nExercise 4.2 #2");
        double[] x = new double[21];
        double[] y = new double[21];
        for (int i = 0; i < x.length; i++) {
            x[i] = 5 * Math.cos(i * Math.PI / 20.0);
            y[i] = Math.pow(Math.pow(x[i], 2) + 1, -1);
        }
        double[] a = coef(21, x, y);

        System.out.println("With chebyshev extrema:");
        for (int i = 0; i < 41; i++) {
            double node = -5 + (i * .25);
            System.out.println("\nNode: " + node);
            System.out.println("f(" + node + "): " + Math.pow(Math.pow(node, 2) + 1, -1));
            System.out.println("p(" + node + "): " + eval(21, x, a, node));
        }

        for (int i = 0; i < x.length; i++) {
            x[i] = 5 * Math.cos((2 * i + 1) * Math.PI / 42.0);
            y[i] = Math.pow(Math.pow(x[i], 2) + 1, -1);
        }
        a = coef(21, x, y);

        System.out.println("With chebyshev roots:");
        for (int i = 0; i < 41; i++) {
            double node = -5 + (i * .25);
            System.out.println("\nNode: " + node);
            System.out.println("f(" + node + "): " + Math.pow(Math.pow(node, 2) + 1, -1));
            System.out.println("p(" + node + "): " + eval(21, x, a, node));
        }
    }


}
