public class FibonacciTest {

    public static void main(String[] args) {
        long x = fibonacci(10);
        System.out.println(x);
    }

    public static long fibonacci(long n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
