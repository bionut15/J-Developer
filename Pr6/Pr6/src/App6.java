
public class App6 {
    static double a, b, x, eps, h;
    static int nmax;
    static boolean error = false;
    static String errorMsg = "";
    static int n = 100000;

    public static double f(double x) {
        return 3. * Math.sin(3. * x) - x + 1.;
    }

    public static double solver(double a, double b) {
        eps = 1.e-09;
        nmax = 100;
        if (Math.signum(f(a)) * Math.signum(f(b)) > 0) {
            errorMsg = ("No solutions in [" + a + "," + b + "]");
            error = true;
            return 0.;
        }
        int n = 0;
        while ((Math.abs(b - a) > eps) && (n <= nmax)) {
            x = (a + b) / 2.;
            if (f(x) == 0.) {
                errorMsg = "The root is: " + x;
                error = false;
                return 0;
            }
            if (Math.signum(f(a)) * Math.signum(f(x)) > 0)
                a = x;
            else
                b = x;
            ++n;
            //System.out.println("[ " +a+","+b+"] >> "+n+") "+ x);
            //System.out.printf("%3d) [%15.9f,%15.9f] > %15.9f\n", n, a, b, x);
        }
        if (n > nmax) {
            errorMsg = "No convergence in " + n + " steps";
            error = true;
        } else {
            errorMsg = "Aproximate solution is (with bisection): " + x + " > " + f(x);
            error = false;
        }
        return x;
    }

    public static void main(String[] args) {
        a = -4.;
        b = 4.;
        h = (b - a) / (n - 1.);
        for (double x = a; x < b; x += h) {
            solver(x, x + h);
            if (!error)
                System.out.println(errorMsg);
        }
    }
}

