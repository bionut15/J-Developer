import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;



import java.util.*;



public class FactorialB {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);

System.out.print("n: ");
int n = in.nextInt();

BigInteger fact = BigInteger.valueOf(1);
for(int i=1; i<=n ; ++i)
fact = fact.multiply(BigInteger.valueOf(i));

//System.out.println(n + "! = " + fact);



BigDecimal A, B, C;
A = BigDecimal.valueOf(5.4);
B = BigDecimal.valueOf(3.14);
C = A.divide(B,20000, RoundingMode.HALF_UP);
System.out.println("C = " + C);

}
}