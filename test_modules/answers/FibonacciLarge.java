import java.math.BigInteger;

public class FibonacciLarge {
    public String fib(int n) {
        if(n == 0) return "0";
        if(n == 1) return "1";

        BigInteger[] arr = new BigInteger[n+1];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");

        for(int i = 2; i < n+1; i++) {
            arr[i] = new BigInteger(arr[i-1].add(arr[i-2]).toString());
        }

        return arr[n].toString();
    }
}

