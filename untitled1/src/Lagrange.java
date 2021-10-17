import java.util.Scanner;
public class Lagrange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x;       //输入
        int n;          //节点数
        System.out.println("请输入X:");
        x = input.nextDouble();
        System.out.println("请输入n:");
        n = input.nextInt();
        double[] ArrayX = new double[n+1];  //x坐标数组
        double[] ArrayY = new double[n+1];  //y坐标数组
        System.out.println("请输入Xi:");
        for(int i = 0;i<ArrayX.length;i++) {
            ArrayX[i] = input.nextDouble();
        }
        System.out.println("请输入Yi:");
        for(int i = 0;i<ArrayY.length;i++) {
            ArrayY[i] = input.nextDouble();
        }
        System.out.println("拉格朗日插值结果为:"+lag(x,n,ArrayX,ArrayY));
    }
    //拉格朗日算法实现函数
    private static double lag(double x,int n,double[] AX,double[] AY) {
        double Y = 0;
        for(int k = 0;k <= n;k++) {
            double t = 1;
            for(int j = 0;j <= n;j++) {
                if(j == k) {
                    j = k+1;
                    if(j>n) {
                        break;
                    }
                }
                //求基函数
                t *= (x - AX[j]) / (AX[k] - AX[j]);
            }
            //求插值
            Y += t*AY[k];
        }
        return Y;
    }
}
