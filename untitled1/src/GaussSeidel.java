import java.util.Scanner;

//高斯赛德尔迭代公式
public class GaussSeidel {
    //测试数据
    private static double[][] datas = {
            {10.0,-1.0,-2.0,7.2},
            {-1.0,10.0,-2.0,8.3},
            {-1.0,-1.0,5.0,4.2}
    };
    private static double[] x = {0.0,0.0,0.0};

    //求从0~i-1,i+1~n时的a(ij)*xk
    private static double getSum(int i,double[] x,double[] y) {
        double sum = 0;
        for(int j = 0;j< datas[0].length-1;j++) {
            if(j<=i-1&&j!=i)
                sum +=datas[i][j]*y[j];
            else if(j>i&&j!=i) {
                sum +=datas[i][j]*x[j];
            }
        }
        return sum;
    }
    //雅克比迭代方法的具体实现
    /*
     * 参数datas:要求解的线性方程组
     * 参数e:求解精度
     * 参数N:允许迭代次数
     * 参数x:保存解向量
     * */
    private static double[] getGS(double[][] datas,double e,int N,double[] x) {
        int length = datas[0].length;
        double[] y = new double[x.length];
        int k = 1;  //迭代次数
        while(k<N) {
            for(int i = 0;i<x.length;i++) {
                y[i] = (datas[i][length-1] - getSum(i,x,y))/datas[i][i];
            }
            if(isAble(x,y,e)) {
                System.out.println("迭代"+k+"次得到结果");
                return y;
            }
            for(int i = 0;i<x.length;i++)
                x[i] = y[i];
            k++;
        }
        throw new RuntimeException("迭代达到最大次数，仍未得到预期结果");
    }
    //判断是否符合精度要求
    private static boolean isAble(double[] x,double[] y,double e) {
        boolean flag = true;
        for (int i = 0 ; i < x.length ; i ++ ) {
            if(Math.abs(x[i] - y[i]) >= e){
                flag = false;
            }
        }
        return flag;
    }
    //主函数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入精度 e:");
        double e = in.nextDouble();
        System.out.println("请输入最大迭代次数：");
        int N = in.nextInt();
        double[] result = getGS(datas,e,N,x);
        System.out.println("x1=" + result[0] + "\tx2=" + result[1] + "\tx3=" + result[2]);
    }
}
