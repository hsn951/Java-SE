import java.io.*;
import java.util.Scanner;
public class Sqlist {
    private int[] data;
    private int maxsize;
    private int length;
Scanner input = new Scanner(System.in);
    public Sqlist() {
        maxsize = 10;
        data = new int[maxsize+1];
        length = 0;
        System.out.println("输入十个数据：");
        for(int i = 1;i<=10;i++) {
            data[i] = input.nextInt();
            length++;
        }
    }
    public void Insert(int elem,int i) {
        if(this.length>=maxsize) {
          //  System.out.println("线性表容量不足");
            maxsize +=10;
            int[] datanew = new int[maxsize];
            for(int j = 1;j<length;j++)
                datanew[j] = data[j];
            data = datanew;
        } else if(i<1||i>maxsize) {
            System.out.println("插入位置有误");
        }
          for(int j=length;i<=j;j--) {
              data[j+1] = data[j];
          }
          data[i]=elem;
          length++;
          System.out.println("插入成功");
    }

    public void delete(int i) {
        if(i<1||i>length)
            System.out.println("删除位置有误");
        else {
            for(;i<length;i++)
                data[i]=data[i+1];
            length--;
            System.out.println("删除成功");
        }
    }

    public void display() {
        System.out.println("线性表容量："+maxsize+" "+"线性表已用空间："+length);
        for(int i =1;i<=length;i++) {
            System.out.println("第"+i+"个元素："+data[i]);
        }
    }

    public int getTop() {
        if(length<1) {
            System.out.println("线性表为空");
            return 0;
        }
       else return data[1];
    }

    public int getData(int i) {
        if(i<1||i>length) {
            System.out.println("无该元素");
            return 0;
        } else return data[i];
    }

    public void change(int i) {
        if(i<1||i>length)
            System.out.println("无该元素");
        else {
            System.out.println("新的数值：");
            data[i]=input.nextInt();
            System.out.println("修改成功");
        }
    }

    public void remove_SameData() {
        int k;
        if(length>0) {
           int j=1;
            for(int i=2;i<=length;i++)  {
                k=1;
                while((k<=j)&&(data[k]!=data[i])) k=k+1;
                if(k==j+1)   {    data[k]=data[i];    j=k;   }
            }
            length=j;
        }

    }

    public int Search_binary(int e) {
        int low = 1,high = length,mid;
        while(low<=high) {
            mid = (low+high)/2;
            if(data[mid]==e) return mid;
            else if(data[mid]<e) low = mid+1;
            else high = mid-1;
        }
        return 0;
    }
  /*
    public void write() {
        File fp = new File("SqList.txt");
    }
   */
    public static void main(String[] args) {
        Sqlist L = new Sqlist();
        L.display();
        L.change(15);
      //  L.change(5);
        L.display();
        L.remove_SameData();
        L.display();
        System.out.println("查找结果"+L.Search_binary(5));
        System.out.println("表头元素："+L.getTop());
        System.out.println("第3位元素："+L.getData(3));
    }
}
