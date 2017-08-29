package tencent;

import java.util.*;
/**
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 * Created by ZeHua on 2017/5/23.
 */
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            String parm = scanner.nextLine();
            if(parm.length()==1)System.out.println(parm);
            char[] datas = parm.toCharArray();
            for(int i=datas.length-2;i>=0;i--){
                if(datas[i]<'a'){
                    //交换,类似冒泡
                    for(int j=i;j<datas.length-1&&datas[j+1]>='a';j++){
                        datas[j+1]=(char)(datas[j]+datas[j+1]);//不能申请额外的空间,A+B
                        datas[j]=(char)(datas[j+1]-datas[j]);//B=A+B-A
                        datas[j+1]=(char)(datas[j+1]-datas[j]);//A=A+B-B
                    }
                }
            }

            System.out.println(new String(datas));

        }
    }
}