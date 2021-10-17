import java.util.Scanner;

public class Runge_Kutta {
    //常微分函数
    private static double f(double x,double y) {
        return y-2*x/y;
    }
    /*
    * 参数h :步长   参数 X[]:x的坐标数组       参数 Y[]:y值数组
    * K1,
    * */
    private static void RungeKutta(double h,double[] X,double[] Y,double tol) {
        double k1,k2,k3,k4;
        for(int i=1; i<=tol; i++)
        {
            k1=f(X[i-1],Y[i-1]);
            k2=f(X[i-1]+h/2,Y[i-1]+h/2*k1);
            k3=f(X[i-1]+h/2,Y[i-1]+h/2*k2);
            k4=f(X[i-1]+h,Y[i-1]+h*k3);
            Y[i]=Y[i-1]+h/6*(k1+2*k2+2*k3+k4);
        }
        for(int i = 1;i<=tol;i++) {
            System.out.println(X[i]+" 的近似解："+Y[i]);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] X =new double[50];
        double[] Y =new double[50];
        System.out.println("输入步长：");
        double h =  in.nextDouble();
        System.out.println("输入区间下限：");
        double left = in.nextDouble();
        System.out.println("输入区间上限：");
        double right = in.nextDouble();
        System.out.println("输入起始Y值：");
        Y[0] = in.nextDouble();
        double tol = (right - left)/h;
        for(int i = 0;i<=tol;i++) {
            X[i] = left + i*h;
        }
RungeKutta(h,X,Y,tol);
    }
}
