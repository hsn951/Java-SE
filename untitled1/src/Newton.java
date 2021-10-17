import java.util.Scanner;
public class Newton {
    static double[][] format;//差商表
public static void main(String[] args) {
    //获取用户输入
    Scanner in = new Scanner(System.in);
    System.out.println("请输入节点数目：");
    int n = in.nextInt();
    //存放X、Y的坐标值
    double[][] XY = new double[2][n];       //存放X,Y的值
    System.out.println("请输入(X，Y)的值：");
    for(int i = 0;i<n;i++){
            XY[0][i] = in.nextDouble();
            XY[1][i] = in.nextDouble();
    }
    CreateFormat(XY,n);
    System.out.println("请输入X：");
    double x = in.nextDouble();
    System.out.println("f(x)="+N(XY,n,x));
}

//建差商表
private static void CreateFormat(double[][] XY,int n) {
    format = new double[n-1][n-1];
    for(int i = 0;i<n-1;i++) {
        for(int j = 0;j<n-i-1;j++) {
            if(i==0) {//初始化差商表
                format[i][j] = (XY[1][j]- XY[1][j+1]) / (XY[0][j]-XY[0][j+1]);
            } else {
                format[i][j] = (format[i-1][j] - format[i-1][j+1]) / (XY[0][j] - XY[0][j+i+1]);
            }
        }
    }
}
    //牛顿插值公式
private static double N(double[][] XY,int n,double x) {
    double sum = XY[1][0];    //求和的初值为f(x0)
    for(int i = 0;i<n-1;i++) {
        double c = 1;
        for(int j = 0;j<i+1;j++) {
            c = (x - XY[0][j])*c;
        }
        sum += format[i][0] * c;
    }
    return sum;
}

}
