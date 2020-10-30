import java.util.ArrayList;
import java.util.Scanner;
public class StockManager {
    Scanner scan1 = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<Product>();  //Product对象容器
    /**
     增加一个新产品
     **/
void addProduct() {
    int stocks;
    String id;
    boolean flag = true;  //flag=true,创建新产品,flag=false，ID已存在，创建失败
    System.out.println("请输入产品名：");
    String name = scan1.nextLine();
    System.out.println("请输入产品ID：");
    id = scan1.nextLine();
    System.out.println("请输入产品库存：");
    stocks = scan1.nextInt();
    String kongge = scan1.nextLine();//接收空格
    for(Product product:products) {
        if(id.equals(product.getID())) {
            System.out.println("当前ID已存在，无法添加，请更换ID重新输入");
            flag = false;
            break;
        }
    }
    if(flag) {
        Product product = new Product(id, stocks, name);  //创建一个新的产品
        products.add(product);    //将新产品加入容器products
    }
}
/**遍历产品容器,输出所有产品信息**/
    void printProductDetails() {
    int i = 0;
    for (Product product : products) {
        System.out.println("product."+(++i));
        System.out.println("------------------------------------");
        System.out.println(product.toString());
        System.out.println("\n");

    }
}
/**
 * 根据产品ID查询产品，并返回该产品信息
 * **/
Product findProduct(String id) {
    for (Product product : products) {
        if (product.getID().equals(id))  //匹配产品成功
            return product;
    }
    return null;
 }
/**
 * 根据ID返回该产品的库存
 * **/
 int numberInStock(String id) {
    for(Product product:products) {
        if(product.getID().equals(id))  //匹配产品成功
            return product.getStocks();
    }
    return 0;  //匹配产品失败
 }
 /**
  * 根据传入的参数ID查找产品，若找到则调用increaseQuantity增加该产品库存数量
  **/
void delivery(String id) {
    boolean flag = true;
    //ID匹配
    for (Product product : products) {
        if (product.getID().equals(id)) {
            flag = false;
            System.out.println("请输入你要增加的库存数量：");
            int num = scan1.nextInt();
            //增加库存
            product.increaseQuantity(num);
        }
    }
    if(flag)
        System.out.println("不存在该ID");

}
/**
 *传入给定水平，输出低于给定水平的产品信息
 * **/
void printLowStockProducts(int level) {
    for (Product product:products) {
        if(product.getStocks()<level)
           System.out.println(product.toString());
    }
}
/**
 * 通过名字查找产品信息
 * **/
Product findProductByName(String name) {
    for(Product product:products) {
        if(name.equals(product.getName()))   //匹配成功
            return product;
    }
return null; //匹配失败
}
}
