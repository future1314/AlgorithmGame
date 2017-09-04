package xiaomi;

import java.util.Scanner;

/**
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。
 * 比如： （1） “hello xiao mi”-> “mi xiao hello”
 *
 * 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
 * hello xiao mi
 *
 * 对于每个测试示例，要求输出句子中单词反转后形成的句子
 * mi xiao hello
 */
public class SentenceReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(!scanner.hasNext())break;
            String param = scanner.nextLine();
            if(param.length()<=0)break;

            String[] words = param.split(" ");
            StringBuilder builder = new StringBuilder();
            for(int i=words.length-1;i>=0;i--){
                builder.append(words[i]);
                if(i!=0){
                    builder.append(" ");
                }
            }

            System.out.println(builder.toString());
        }
    }
}
