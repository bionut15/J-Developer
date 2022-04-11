public class BisectionV2 {


    public static void main(String[] args) {
        double a, b, xm = Double.NaN, eps, fa, fm,x,fx;
        a = 0.;
        b = 3.;
        eps = 1.e-15;
        x = 1;
        int c = 1;
        int MAXITER = 1000;


        do {
            xm = (a + b) / 2.;

            fa = Math.cos(Math.sin(Math.exp(a))) - 0.8;
            fm = Math.cos(Math.sin(Math.exp(xm))) - 0.8;
            fx = Math.cos(Math.sin(Math.exp(x)));

            if (Math.signum(fa) * Math.signum(fm) > 0.)
                a = xm;
            else
                b = xm;
            System.out.printf("%3d  %10.5f  %10.5f  %15.12f  %15.12f  \n",c ,a,b,Math.abs(a - b),xm);
           if(c>MAXITER) break;
        }
        while(Math.abs(fx) > eps);
        System.out.println(xm);
    }

}
