import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sin;

public class ComplexTrap {
    //数据
    private static Double [] data_x = {0.0,0.125,0.250,0.375,0.5,0.625,0.750,0.875,1.0} ;
    private static Double [] data_y = {1.0,0.997,0.990,0.977,0.954,0.936,0.909,0.877,0.841} ;

    private  static List<Double> X = Arrays.asList(data_x);
    private  static List<Double> Y = Arrays.asList(data_y);

    //复化梯形求积
    /*
    * 参数a:积分下限
    * 参数b:积分上限
    * 参数n:划分
    * */
    private static double getValue(float a,float b,int n) {
        //计算步长
        float h = (b - a)*1.0f/n;
        //结果
        double result = Y.get(0) + Y.get(n);
        for(int i = 1;i<n;i++) {
            result += Y.get(i)*2;
        }
        return result*h/2;
    }

    //变步长复化梯形法
    /*
     * 参数a:积分下限
     * 参数b:积分上限
     * 参数e:精度
     * */
    private static double getValue1(float a,float b,double e) {
        //起始步长
        float h = b - a;
        /*
        * T1:二分前积分值
        * T2:二分后积分值
        * S:新增节点函数值求和
        * */
        double T1,T2,S;
        T2 = (1+f(b))*(b-a)/2;
        int k =0;
        int times = 1;  //新划分数
        double nume;
        do{
            T1 = T2;
            S = 0;
            nume = a + h/2;
            //对新增节点进行求和
            for(int i =0;i<times;i++) {
                S += f(nume);
                nume +=h;
            }
            times *=2;
            T2 = T1/2 + h*S*0.5;
            h /=2;
            k++;
        }while((T2 - T1 -e)>=0);
        System.out.println("二分次数："+k);
        return T2;
    }

    private static double f(double x) {
        return sin(x)/x;
    }
    public static void main(String[] args) {
        System.out.println("函数在区间的积分为："+ getValue(1e-20f,1.0f,8));
        System.out.println("变步长复化梯形法："+getValue1(0,1,1e-5));
    }
}
