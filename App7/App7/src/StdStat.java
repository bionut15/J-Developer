import java.util.Scanner;

public class StdStat {
    public static int readInt(String txt) {
        Scanner in = new Scanner(System.in);
        System.out.print(txt);
        return in.nextInt();
    }

    public static double readDouble(String txt) {
        Scanner in = new Scanner(System.in);
        System.out.print(txt);
        return in.nextDouble();
    }

    public static double[] readVector() {
        int n;
        double a[];
        n = readInt("n: ");
        a = new double[n];
        for (int i = 0; i < n; ++i)
            a[i] = readDouble(String.format("a[%d]: ", i));
        return a;
    }

    public static void printVector(double a[]) {
        for (int i = 0; i < a.length; ++i) {
            if (i < a.length - 1)
                System.out.printf("%f, ", a[i]);
            else
                System.out.printf("%f\n", a[i]);
        }
    }

    public static double minVector(double a[]) {
        double min = a[0];
        for (int i = 1; i < a.length; ++i)
            if (a[i] < min)
                min = a[i];
        return min;
    }

    public static double maxVector(double a[]) {
        double max = a[0];
        for (int i = 1; i < a.length; ++i)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static double mean(double a[]) {
        double sum = 0.;
        for (int i = 0; i < a.length; ++i)
            sum += a[i];
        return sum / a.length;
    }

    public static double vari(double a[]) {
        double sum = 0., avg = mean(a);
        for (int i = 0; i < a.length; ++i)
            sum += (a[i] - avg) * (a[i] - avg);
        return sum / a.length;
    }

    public static double stddev(double a[]) {
        return Math.sqrt(vari(a));
    }

    public static void main(String[] args) {
        double x[];
        x = readVector();
        printVector(x);
        System.out.printf("mean is: %f\nvariance is: %f\nstandard deviation is: %f\n", mean(x), vari(x), stddev(x));
    }
}

