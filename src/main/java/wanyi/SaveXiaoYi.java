package wanyi;

import java.util.Scanner;

/**
 *有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。
 * 大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。
 * 你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
 *
 第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
 第二行有n个整数xi，表示第i个陷阱的横坐标
 第三行有n个整数yi，表示第i个陷阱的纵坐标
 保证坐标都在草地范围内。

 输出一个整数,表示小易最少可能多少秒就落入超超的陷阱

 3
 4 6 8
 1 2 1

 3
 */
public class SaveXiaoYi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(!scanner.hasNext())break;

            String firstLine = scanner.nextLine();
            String secondLine = scanner.nextLine();
            String thirdLine = scanner.nextLine();

            if(firstLine.length()<=0||secondLine.length()<=0||thirdLine.length()<=0)break;

            int trapNum = Integer.parseInt(firstLine);

            String[] xStrings = secondLine.split(" ");
            String[] yStrings = thirdLine.split(" ");

            int[] x = new int[xStrings.length];
            int[] y = new int[yStrings.length];

            for(int i=0;i<x.length;i++){
                x[i]=Integer.parseInt(xStrings[i]);
                y[i]=Integer.parseInt(yStrings[i]);
            }

            int[] array = new int[x.length];//落入陷阱i所需最少时间
            for(int i=0;i<array.length;i++){
                array[i] = x[i]+y[i]-2;
            }

            int min = array[0];
            for(int i=1;i<array.length;i++){
                if(array[i]<min){
                    min=array[i];
                }
            }

            System.out.println(min);
        }
    }
}
