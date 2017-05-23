package baidu;

import java.util.Scanner;

/**
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
 * 度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格
 * （价格均是正整数，且小于等于1000）
 *
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 *输入例子:
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 *输出例子:
 * 30
 *
 * Created by ZeHua on 2017/5/23.
 */
//封装一个特殊的表,表内只有3个元素
class HelpList {
    private int[] hatArr = new int[3];
    private int top=-1;
    public void push(Integer val) {

        //栈内少于3个元素的情况
        if (top < 2) {
            if (top == -1 || val > hatArr[top]) {
                top++;
                hatArr[top] = val;
                return;
            }
            for(int i=0;i<=top;i++){
                if(hatArr[i]==val){
                    return;
                }
            }
            top++;
            hatArr[top] = val;
            for (int i = top; i > 0 && hatArr[i - 1] > hatArr[i]; i--) {
                int temp = hatArr[i - 1];
                hatArr[i - 1] = hatArr[i];
                hatArr[i] = temp;
            }


        } else {//栈内不少于3个元素的情况
            for(int i=0;i<=top;i++){
                if(hatArr[i]==val){
                    return;
                }
            }
            if (val < hatArr[top]) {
                int temp = val;
                val = hatArr[top];
                hatArr[top] = temp;
            }
            for (int i = top; i > 0 && hatArr[i - 1] > hatArr[i]; i--) {
                int temp = hatArr[i - 1];
                hatArr[i - 1] = hatArr[i];
                hatArr[i] = temp;
            }
        }
    }
    public int top(){
        if(top!=2)return -1;
        return hatArr[top];
    }
}
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            HelpList hatlist = new HelpList();
            int num_hat = Integer.parseInt(scanner.nextLine());
            String[] parm_price = scanner.nextLine().split("\\s");
            if(num_hat<3){
                System.out.println(-1);
                continue;
            }
            for(int i=0;i<parm_price.length;i++){
                hatlist.push(Integer.parseInt(parm_price[i]));
            }
            System.out.println(hatlist.top());
        }
    }
}

