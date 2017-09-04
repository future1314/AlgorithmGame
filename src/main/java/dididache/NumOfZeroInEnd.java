package dididache;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 输入为一行，n(1 ≤ n ≤ 1000)
 *
 * 输出一个整数,即题目所求
 *
 * 10
 *
 * 2
 */
public class NumOfZeroInEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(!scanner.hasNext())break;
            String param = scanner.nextLine();
            if(param.length()<=0)break;
            int n = Integer.parseInt(param);

            BigInteger bigInteger = new BigInteger("1");
            for(int i=2;i<=n;i++){
                bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
            }

            BigInteger ten = new BigInteger("10");
            BigInteger zero = new BigInteger("0");
            int numOfZero = 0;
            for(BigInteger pos = new BigInteger("10");pos.compareTo(bigInteger)==-1;pos=pos.multiply(ten) ){
                if(bigInteger.remainder(pos).compareTo(zero)==0){
                    numOfZero++;
                }else {
                    break;
                }
            }

            System.out.println(numOfZero);
        }
    }
}
