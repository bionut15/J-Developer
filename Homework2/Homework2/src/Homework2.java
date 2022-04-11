import java.util.Scanner;

public class Homework2 {

 public static double readDouble(String txt) {
Scanner in = new Scanner(System.in);
System.out.print(txt);
return in.nextDouble();
}

 public static int readInt(String txt) {
Scanner in = new Scanner(System.in);
System.out.print(txt);
return in.nextInt();
}

 public static String Line(char ch, int n) {
String s = "";
for (int i = 0; i <= n; ++i, s += ch)
;
return s;
}

 public static String compute(double a, double b, int n) {
double h, x;
int i;

 String s = Line('+',32);
s += "\n" + "| i | x | f(x) |";
s += "\n" + Line('+',32);
s += "\n";

 h = (b - a) / (n - 1.);

 for (i = 1; i <= n; ++i) {
x = a + (i - 1) * h;
s += String.format("| %3d | %+9.4f | %+10.8f |\n", i, x, Math.sin(x) * Math.exp(-x));
}
s += Line('+',32);

 return s;

 }

 public static void main(String[] args) {
System.out.println(compute(readDouble("a= "), readDouble("b= "), readInt("n= ")));
}
}