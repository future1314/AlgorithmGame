package baidu;

import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。
 * 现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，
 * 问度度熊回家至少走多少距离？
 * Created by ZeHua on 2017/5/23.
 */
public class BearGoHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int[] pos = new int[num];
            for(int i=0;i<pos.length;i++){
                pos[i]=scanner.nextInt();
//                System.out.println(pos[i]);
            }
            int out_res=Integer.MAX_VALUE;
            for(int i=1;i<pos.length-1;i++){
                int res=0;
                for(int cur=1;cur<pos.length;cur++){//计算距离
                    int pre = cur-1;//前一个坐标的下标
                    //跳过忽略点i
                    if(cur == i){
                        cur++;
                    }
                    res=res+Math.abs(pos[cur]-pos[pre]);

                }
                out_res=Math.min(out_res,res);//得到更小距离
            }

            System.out.println(out_res);
        }
    }
}
