import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinearFitting {
    //数据
    private static Double [] data_x = {165.0,123.0,150.0,123.0,141.0} ;
    private static Double [] data_y = {187.0,126.0,172.0,125.0,148.0} ;

    private  static List<Double> x = Arrays.asList(data_x);
    private  static List<Double> y = Arrays.asList(data_y);

    //对Xi、Yi求和
    private static double getSumX(List<Double> datas) {
        double result = 0.0;
        for (int i = 0;i<datas.size();i++) {
            result += datas.get(i);
        }
        return result;
    }

    //对Xi * Yi和Xi^2求和
    private static double getSumXY(List<Double> x,List<Double> y) {
        if(x.size() != y.size()) {
            throw new RuntimeException("输入坐标数据数目有误！");
        }
        double result = 0.0;
        for(int i =0;i<x.size();i++) {
            result += x.get(i) * y.get(i);
        }
        return result;
    }
    /*
    * 参数x:存放横坐标的容器
    * 参数y:存放纵坐标的容器
    * */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        double Sum_x = getSumX(x);  //x和
        double Sum_y = getSumX(y);  //y和
        double Sum_xy = getSumXY(x,y);//x*y和
        double Sum_xx = getSumXY(x,x); //x*x和
        double b = (y.size()*Sum_xy - Sum_y*Sum_x)/(y.size()*Sum_xx - Sum_x*Sum_x);
        double a = (Sum_y - b*Sum_x)/y.size();
        System.out.println("请输入预测点横坐标：");
        double InX = cin.nextDouble();
        System.out.println("线性拟合曲线为y = "+a+b+"x");
        System.out.println("线性拟合结果为："+(a+b*InX));

    }
}
