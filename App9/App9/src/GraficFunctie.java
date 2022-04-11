public class GraficFunctie {
    static double f(double x) {
        //return Math.sin(x * 5.) * x - 0.5;
        return x * x + 2. * x - 1.; //x^2+2x-1
        //return x ; //x^2-2x-1
        //2x-2
        //return Math.sqrt(16-x*x);
    }

    static double fd1(double x) {
        double h = 0.001;
        return (f(x + h) - f(x)) / h;
    }

    static double s(double f, double fmin, double fmax) {
        return (f - fmin) / (fmax - fmin);
    }

    static double min(double a[]) {

        double min = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }

    static double max(double a[]) {
        double max = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        double a, b, h, eps = 0.025;
        int i, n, LY = 40;
        a = -6.;
        b = 4;
        n = 41;
        double x[] = new double[n];
        double y[] = new double[n];
        double yd1[] = new double[n];
        h = (b - a) / (n - 1.);
        for (i = 1; i <= n; ++i) {
            x[i - 1] = a + (i - 1.) * h;
            y[i - 1] = f(x[i - 1]);
            yd1[i - 1] = fd1(x[i - 1]);
            //System.out.printf("%3d) %7.4f %7.4f\n", i, x[i - 1], y[i - 1]);
        }
        double ymin = Math.min(min(y), min(yd1));
        double ymax = Math.max(max(y), max(yd1));
        int posOX = (int) (LY * s(0, ymin, ymax));
        for (i = 0; i < x.length; ++i) {
            int posy = (int) (LY * s(y[i], ymin, ymax));

            int posyd = (int) (LY * s(yd1[i], ymin, ymax));
            String s = "";
            for (int k = 0; k <= LY; ++k) {
                if (k == posyd) {
                    s += "d";
                    continue;
                }
                if (k == posy) {
                    s += "x";
                    continue;
                }
                if (k == posOX) {
                    s += "|";
                    continue;
                }
                if (Math.abs(x[i]) <= eps) {
                    s += "-";
                    continue;
                }
                s += " ";
            }
            //System.out.printf("%3d) %7.4f %7.4f %s\n", i + 1, x[i], y[i], s);
            //System.out.printf("%3d) %7.4f %7.4f %3d  |  %s\n", i + 1, x[i], y[i], posy, s);
            System.out.printf("%3d) %7.4f %7.4f %8.4f %s\n", i + 1, x[i], y[i], fd1(x[i]), s);
        }
    }
}
