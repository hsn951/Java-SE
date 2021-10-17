import java.text.DecimalFormat;
import java.util.Scanner;

public class Euler {
    public static double getFunc(double x,double y) {
        return y-(2*x)/y;
    }

    /*
    * x0:初值x
    * y0:初值y
    * h:步长
    * n:步数
    * */
    static void getEuler(double x0,double y0,double h,int n) {
        DecimalFormat df = new DecimalFormat("#0.0");
        for(int i = 1;i<=n;i++) {
            double x1 = x0+h;
            double y1 = y0 +h*getFunc(x0,y0);    //预报
            double y2 = y0+h*getFunc(x1,y1);     //校正
            y1 = (y1+y2)/2;  //改进值
            x0 = x1;
            y0 = y1;
            System.out.println("x:"+df.format(x1)+"----> y:"+y1);
        }
    }
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//    float x0 = in.nextFloat();
//    float y0 = in.nextFloat();
//    float h = in.nextFloat();
//    int n = in.nextInt();
    getEuler(0,1,0.1 ,10);
}

}
