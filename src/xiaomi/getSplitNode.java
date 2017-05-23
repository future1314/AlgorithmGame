package xiaomi;

import static java.lang.System.out;

/**
 * git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，比如：
 * base'<--base<--A<--A' ^ | --- B<--B'
 * 小米工程师常常需要寻找两个分支最近的分割点，即base.假设git 树是多叉树，请实现一个算法，计算git树上任意两点的最近分割点。
 * （假设git树节点数为n,用邻接矩阵的形式表示git树：
 * 字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，长度为n。matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。
 * 节点0为git树的根节点。）
 * Created by ZeHua on 2017/5/22.
 */
public class getSplitNode {
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {

        if(indexA==indexB) return indexA;

        int nodeNum = matrix.length;
        int tree[] = new int[nodeNum];
        boolean flag[] = new boolean[nodeNum];

        for(int i=0; i<tree.length; i++){
            tree[i]=i;
        }

        dfs(0, tree, matrix);

        int a = indexA;
        int b = indexB;

        while(tree[a]!=a){
            flag[a] = true;
            a = tree[a];
        }

        while(tree[b]!=b){
            if(flag[b]){
                break;
            }
            b = tree[b];
        }

        return b;
    }

    public void dfs(int root, int[] tree, String[] matrix){
        for(int i=0; i<tree.length; ++i){
            if(matrix[root].charAt(i) == '1' && tree[i]==i && i!=0){
                tree[i] = root;
                dfs(i, tree, matrix);
            }
        }
    }

    public static void main(String[] args) {
        String[] arr ={"01011","10100","01000","10000","10000"};
        String[] arr2 ={"0"};
        out.println(new getSplitNode().getSplitNode(arr2,0,0));
    }
}
