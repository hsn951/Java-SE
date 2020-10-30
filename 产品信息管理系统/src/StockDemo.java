import java.util.Scanner;

public class StockDemo {
    public static void main(String[] args) {
        Scanner scan2 = new Scanner(System.in);
        StockManager stockmanager1 = new StockManager();
        String id = null;
while(true) {
    System.out.println("1.addProduct");
     System.out.println("2.printProductDetails");
      System.out.println("3.findProduct");
       System.out.println("4.numberInStock");
        System.out.println("5.delivery");
         System.out.println("6.printLowStockProducts");
          System.out.println("7.findProductByName");
           System.out.println("exit.退出系统");
           System.out.println("输入你要进行的操作：");
   // String inEnter = scan2.nextLine();  //接收空格
    String choice = scan2.nextLine();
           switch(choice) {
               case "1":    stockmanager1.addProduct();break;
               case "2":            stockmanager1.printProductDetails();break;
               case "3":
                   System.out.println("输入你要查询产品的ID：");
                   id = scan2.nextLine();
                   Product reProduct = stockmanager1.findProduct(id);
                   //判断容器内是否存在该product
                   if(reProduct==null)
                         System.out.println("未查到该产品");
                   else
                       System.out.println(reProduct.toString());
                   break;
               case "4":
                   System.out.println("输入你要查询产品的ID：");
                   id = scan2.nextLine();
                   if(stockmanager1.numberInStock(id)!=0)
                   System.out.println("该产品库存数量："+stockmanager1.numberInStock(id));
                   break;
               case "5":
                   System.out.println("输入你要增加库存的产品的ID：");
                   id = scan2.nextLine();
                   stockmanager1.delivery(id);
                   break;
               case "6":
                   System.out.println("输入给定水平值：");
                   int level = scan2.nextInt();
                  String kongge = scan2.nextLine();//接收空格

                   stockmanager1.printLowStockProducts(level);
                   break;
               case "7":
                   System.out.println("输入要查询的产品名字：");
                   String name = scan2.nextLine();
                   if(stockmanager1.findProductByName(name)==null)System.out.println("该产品不存在");
                   else {
                       reProduct = stockmanager1.findProductByName(name);
                       System.out.println(reProduct.toString());
                   }
                   break;
               case "exit":System.exit(0);
               default:System.out.println("输入选项有误，请重新输入：");
              }
           }
        }
    }

