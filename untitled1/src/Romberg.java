import java.util.Scanner;

public class Romberg {

    private static double f(double x) {
        if(x==0)
            return 1.0;
        return Math.sin(x)/x;
    }
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("请输入下限：");
        double a=in.nextDouble();
        System.out.println("请输入上限：");
        double b = in.nextDouble();
        System.out.println("请输入迭代次数：");
        double count = in.nextDouble();
        System.out.println("请输入精度控制：");
        double e = in.nextDouble();
        getAns(a,b,count,e);
        //System.out.println("龙贝格迭代后："+result);
    }
    private static double getAns(double a,double b,double count,double e) {
        double h = b -a;
        double T1 = h*(f(a)+f(b))/2,T2 = 0;
        double x,sum,R1=0,R2=0,C1=0,C2,S2,S1=0;
        double[][] num = new double[10][4];
        int k = 1;
        while(k<count) {  //参数count：最多迭代次数
             sum = 0;
            for( x = a + h/2; x < b; x += h)
                sum += f(x);
            T2 = (T1 + sum*h)/2;
            num[k][0] = T2;
            S2 = T2 + (T2 - T1)/3;//梯形
            num[k][1] = S2;
            if(k != 1){
                C2 = S2 + (S2 - S1)/15;//辛普森
                num[k][2] = C2;
                if(k != 2){
                    R2 = C2 + (C2 - C1)/63; //龙贝格
                    num[k][3] = R2;
                    if(k != 3)
                        if(Math.abs(R2 - R1) < e){
                        System.out.println("龙贝格求积求得结果是: "+R2);
                        System.out.println("迭代次数为："+k);
                        break;
                    }
                    R1 = R2;
                }
                C1 = C2;
            }
            h /= 2;//逐步减小步长
            k++;
            T1 = T2;
            S1 = S2;

        }
        return R2;

    }
}
