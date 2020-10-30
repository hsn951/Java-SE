public class Product {
    private int stocks;   //产品ID，库存
    private String name,ID;      //产品名字
    Product() {name = null;ID = null;stocks = 0;}
    Product(String id,int stocks,String name) {
        ID = id;
        this.stocks = stocks;
        this.name = name;
    }
    //增加库存量
    public void increaseQuantity (int addition) {
stocks = stocks+addition;
    }
    //售出一件库存
    public void SellOne() {
        stocks--;
    }
    //返回ID
    String getID() { return ID; }
    //返回产品名字
    String getName() { return name;}
    //返回产品现库存
    int getStocks() {return stocks;}
    //输出产品信息
    public String toString() {
        String stocksString = ""+stocks;
        return name+" "+ID+" "+stocksString;
    }
}
