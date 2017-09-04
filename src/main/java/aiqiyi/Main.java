package aiqiyi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Choose{
    long price;
    long num_play;

    public Choose(long price, long num_play) {
        this.price = price;
        this.num_play = num_play;
    }
}

/**
 * 2017爱奇艺全国高校技术大赛算法比赛初试第一题
 * 题目大意类似：
 * 10 5 7 2 3 8 10 3 4
 * 输入一行，
 * 第一列为拥有的金额
 *
 * 第二列为购买所需金额
 * 第三列为回报
 * 4，5和6，7还有8，9类似二，三列
 *
 * 输出能得到的最大回报
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String in_string = sc.nextLine();
        String[] num_string = in_string.split("\\s");



        long B_monney =Long.parseLong(num_string[0]) ;
        /**
         * 返回结果
         */
        long res =0;
        /**
         * 总价格
         */
        long price_all = 0 ;
        /**
         * 总播放
         */
        long play_all = 0 ;

        ArrayList<Choose> all_choose = new ArrayList<>();

        LinkedList<Choose> help = new LinkedList<>();
        LinkedList<Choose> cache = new LinkedList<>();

        for(int i=1;i<num_string.length;i=i+2){
            all_choose.add(new Choose(Long.parseLong(num_string[i]),Long.parseLong(num_string[i+1])));
        }

        for(int i=0;i<all_choose.size();i++){
            Choose cur = all_choose.get(i);
            long next_price_all = price_all+ cur.price;
            if(next_price_all<=B_monney){
                price_all=next_price_all;
                play_all=play_all+cur.num_play;
                res=Math.max(res,play_all);
                //应该以价格排序
                while(!help.isEmpty()&&help.getLast().price>=cur.price){
                    cache.push(help.pollLast());
                }
                help.addLast(cur);
                while(!cache.isEmpty()){
                    help.addLast(cache.pop());
                }
            }else {
                //可能出现后面price比它大，改for
                if(help.getLast().num_play<=cur.num_play&&help.getLast().price>=cur.price){
                    Choose abandoned = help.pollLast();
                    price_all=price_all-abandoned.price;
                    play_all= play_all-abandoned.num_play;

                    price_all=price_all+cur.price;
                    play_all=play_all+cur.num_play;

                    res =Math.max(play_all,res);

                    while(!help.isEmpty()&&help.getLast().num_play<cur.num_play){
                        cache.push(help.pollLast());
                    }
                    help.addLast(cur);
                    while(!cache.isEmpty()){
                        help.addLast(cache.pop());
                    }
                }
            }
        }

        //10 5 7 2 3 8 10 3 4
//        for(int i=0;i<all_choose.size();i++){
//            System.out.println(all_choose.get(i).price+","+all_choose.get(i).num_play);
//        }

        System.out.println(res);
	}
}