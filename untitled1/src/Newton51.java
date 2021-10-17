import java.util.Scanner;

public class Newton51 {

    //牛顿迭代法
    private static double getAns(double x,double e,int N) {
        double result,x1;
        int k =1;  //迭代计数变量
    while(true) {
        if(f(x)==0) {
            throw new RuntimeException("出现奇异情况！");
        }
        x1 = x - F(x)/f(x);
        if(Math.abs(x1 - x)<e) {
            System.out.println("迭代"+k+"次得到结果");
            return x1;
        }
        if(k==N) {
            throw new RuntimeException("迭代失败，已达到最大迭代次数");
        }
        x = x1;
        k++;
    }
    }
    //原函数
    private static double F(double x) {
        return Math.log(x) + x*x;
    }
    //函数导数
    private static double f(double x) {
        return 2*x + 1/x;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入近似解：");
        double x = scanner.nextDouble();
        System.out.print("请输入允许精度：");
        double e = scanner.nextDouble();
        System.out.print("请输入最大迭代次数：");
        int N = scanner.nextInt();
        scanner.close();
        double res = getAns(x,e,N);
        System.out.println("Newton方式得到的解为：" + res);
    }
}
