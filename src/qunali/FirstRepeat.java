package qunali;

import java.util.*;
/**
 * Created by ZeHua on 2017/5/22.
 */
public class FirstRepeat {
    public char findFirstRepeat(String A, int n) {
        char[] cache = new char[256];
        for(int i=0;i<A.length();i++){
            int cur = A.charAt(i);
            if(cache[cur]==(char)cur){
                return (char)cur;
            }else{
                cache[cur]=(char)cur;
            }
        }
        return 0;
    }
}