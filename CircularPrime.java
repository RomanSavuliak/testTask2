import java.util.ArrayList;
import java.util.Arrays;

public class CircularPrime {
    public static void main(String[] args) {

        int N = 1000000;
        boolean []isPrime = new boolean[N];

        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i=2; i*i < N; i++)
            if (isPrime[i])
                for (int j=i*i; j < N; j+=i)
                    isPrime[j] = false;


        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
           if (isPrime[i] == true)
               prime.add(i);
        }


        int count = 0;
        for (int i = 0; i < prime.size(); i++) {
            if (isCircular(prime.get(i), prime))
            count++;
        }
        System.out.println(count);

    }

    public static boolean isCircular(int n, ArrayList<Integer> list){
        int x = n;
        boolean isCirc = true;
        boolean l;
        for (int i = 0; i < intLength(n); i++) {
            x = move(x);
            l = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j)==x)
                    l = true;
            }
            isCirc = isCirc && l;
            if (l == false)
                break;

        }
        return isCirc;
    };

    public static int move(int number){
        int length = intLength(number);
        int x = number % 10;
        number /= 10;
        return  number + x *(int)Math.pow(10, length -1 );
    };

    public static int intLength(int n){
        int count = 0;
        while (n>0){
            n = n/10;
            count++;
        }
        return count;
    }

}
