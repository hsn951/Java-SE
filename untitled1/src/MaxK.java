import java.util.Scanner;
import java.io.*;
public class MaxK {

     static int getVal(int[] num,int i,int j) {
        int sum = 0;
        for(int k = i;k<j;k++) {
            sum +=num[k];
            sum *= 10;
        }
        return sum + num[j];
    }

    static void dpAlgo(int l,int k,int[] num) {

    }

    public static void main(String[] args) {
         int n,k,I;
        //dp[i][j]：前i个元素分成j段得到的最大乘积
        int[][] dp = new int[20][20];
        int[] num = new int[20];  //第i位到第j位组成的（j - i+1)位整数

         Scanner in = new Scanner(System.in);
         System.out.println("请输入整数位数:");
         n = in.nextInt();
        System.out.println("请输入分段整数K:");
        k = in.nextInt();
        System.out.println("请输入数字I:");
        I = in.nextInt();

        if(k == 1)  //分段数为一时等于其本身
        {
            System.out.println("最大K乘积为:"+ I);
            return;
        }
        //把数值转换成数组存储
        int temp =0;
        for(int i = n-1;i>=0;i--) {
            temp = I % 10;
            I = I / 10;
            num[i] = temp;
        }

        for(int t = 0;t<n;t++) {
            dp[0][t] = getVal(num,0,t);
        }
        for(int i = 0;i<n;i++) { //i--表列
            for(int j = 1;j<k;j++){  //j--表行
                if(j>i) {
                    dp[j][i] = 0;   //分段数大于整数位数
                    break;
                }
                if(j<=i) {
                    int max = 0;
                    int temp1 = 0;
                    //根据子问题最优解逐步求当前最优解
                    for(int x = i-1;x>=0;x--) {
                        int nnum = getVal(num,x+1,i);
                        temp1 = nnum*dp[j-1][x];
                        if(temp1>max) {
                            max = temp1;  //逐一计算留下最优
                        }
                    }
                    dp[j][i] = max;
                }
            }
        }
        System.out.println("最大K乘积为："+dp[k-1][n-1]);
    }
}
