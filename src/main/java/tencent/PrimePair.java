package tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）

 输入包括一个整数n,(3 ≤ n < 1000)

 输出对数

 10

 2
 */
public class PrimePair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(!scanner.hasNext())break;
            String param = scanner.nextLine();
            if(param.length()<=0)break;

            int n = Integer.parseInt(param);
            List<Integer> primes = new ArrayList();
            for(int i=2;i<=n;i++){
                if(isPrime(i)){
                    primes.add(i);
                }
            }

            int cpNum = 0;
            for(int i=0;i<primes.size();i++){
                int cur = primes.get(i);
                for(int t=i;t<primes.size();t++){
                    int next = primes.get(t);
                    if(cur+next==n){
                        cpNum++;
                    }
                }
            }

            System.out.println(cpNum);
        }
    }

    private static boolean isPrime(int number) {
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
