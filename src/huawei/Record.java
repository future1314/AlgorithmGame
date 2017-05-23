package huawei;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 题目描述：
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.

 输入包括多组测试数据。
 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 学生ID编号从1编到N。
 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * Created by ZeHua on 2017/5/22.
 */
class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            //处理第一行参数
            String inString = scanner.nextLine();
            String[] inParm=inString.split("\\s");
            int studentNum = Integer.parseInt(inParm[0]);
            int[] score = new int[studentNum];
            int operateNum = Integer.parseInt(inParm[1]);

            //处理第二行参数
            inString = scanner.nextLine();
            inParm=inString.split("\\s");
            for(int i=0;i<score.length;i++){
                score[i]=Integer.parseInt(inParm[i]);
            }
            Record record = new Record(score);

            ////处理后面operateNum行参数
            for(int i=0;i<operateNum;i++){
                inString = scanner.nextLine();
                inParm=inString.split("\\s");
                int a = Integer.parseInt(inParm[1]);
                int b = Integer.parseInt(inParm[2]);
                if(inParm[0].equals("Q")){
                    int outParm =  record.query(a-1,b-1);
                    out.println(outParm);
                }else if(inParm[0].equals("U")){
                    record.update(a-1,b);
                }
            }

        }
    }
}

/**
 * 封装成绩数据，以及对它的操作
 */
class Record{
    private int[] score;
    public Record(int[] score){
        this.score=score;
    }
    public int query(int a,int b){
        if(a<0||b>=score.length){
            throw new RuntimeException();
        }
        if(b<a){
            int temp=b;
            b=a;
            a=temp;
        }
        int res=0;
        for(int i=a;i<=b;i++){
            res=Math.max(score[i],res);
        }
        return res;
    }

    public void update(int id,int his_score){
        if(id<0||id>=score.length||his_score<0){
            throw new RuntimeException();
        }
        score[id]=his_score;
    }

}
