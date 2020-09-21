public class Main {
    public static void main(String[] args) {
        //练习1-1
        Circle circle1=new Circle();
        Square square1=new Square();
        System.out.println("SUCCESS run");

        //练习1-2
        for (int i=0;i<2;i++) {
            circle1.moveDown();
             circle1.makeInvisible();
              square1.moveDown();
               square1.makeInvisible();
        }
        //练习1-3
        circle1.moveVertical(10);
         circle1.slowMoveVertical(-10);
          circle1.changeSize(10);
           circle1.moveHorizontal(-70);
        int y=circle1.GetyPosition();
        System.out.println(y);
    }
}
