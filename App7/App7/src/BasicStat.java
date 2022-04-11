import java.util.Scanner;

public class BasicStat {
    public static void main(String[] args) {
        double x[];
        int n;
        System.out.print("n=");
        Scanner r = new Scanner(System.in);
        n = r.nextInt();
        x = new double[n];

        for (int i = 0; i < n; ++i) {
            System.out.print("x[" + i + "]=");
            x[i] = r.nextDouble();
        }

        for (int i = 0; i < n; ++n) {
            if (i == n - 1) {
                System.out.printf("%9.5f/n", x[i]);
            } else {
                System.out.printf("%8.5f,  ", x[i]);

            }
        }

        double min = x[0];
        for (int i = 1; i < n; ++i) {
            if (x[i] < min) {
                min = x[i];
                System.out.print("min is" + min);
            }
        }

        double max = x[0];
        for (int i = 1; i < n; ++i) {
            if (x[i] > min) {
                min = x[i];
                System.out.print("max is" + max);
            }
        }
        
        double mean = 0;
        for(int i=0; i<n ; ++i){
            mean = min + x[i];
            mean=min/x.length;
        }
        
        double var =0 ;
        for(int i =0; i<n ; ++i ){
            var += (x[i]-min)*(x[i]- max);
            var = x.length;
    }

}
}
