import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("请输入区间下限：");
        double a = in.nextDouble();
        System.out.println("请输入区间上限：");
        double b = in.nextDouble();
        System.out.println("请输入允许精度：");
        double e = in.nextDouble();
        List<Double> result = getAns(a,b,e);
        System.out.println("计算得到的零点值为：x = "+result.get(0));
        System.out.println("该点的函数值为：y = "+result.get(1));

    }

    /*
    * a:区间下限
    * b:区间上限
    * e:精度
    * */
    private static List<Double> getAns(double a,double b,double e) {
        if(b<=a) {
            throw new RuntimeException("上限<=下限，无法计算");
        }
        List<Double> result = new ArrayList<>();
        double y0,x,y;
        x = y = 0;
        y0 = f(a); //f()--要求根的函数
        int i = 0;
        //精度满足时退出
        while((b - a)>=e) {
            i++;
            x = (a+b)/2; //取中点
            y = f(x);   //计算中点值
            if(y*y0>0) {
                a = x;
            } else {
                b =x;
            }
            if(i >=1000) {
                System.out.println("运行超时");
                break;
            }
        }
        result.add(x);
        result.add(y);
        return result;
    }

    //需求根函数
    private static double f(double x) {
        return x*x*x - x -1;
    }
}
