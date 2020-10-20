import java.util.Scanner;
public class TicketMachine {
        int price;
        int balance;
        int total;

        void setPrice(int price) {
            this.price = price;
        }

        void insertMoney(int amount) {
            balance += amount;
        }

        int getBalance() {
            return balance;
        }

        void print() {    //修改处，新增余额判断，金额不足
            System.out.println ("票数:");
            Scanner scanf = new Scanner(System.in);
            int amout = scanf.nextInt();
            if (getBalance()>=(amout*price)) {
                for (int i=0;i<amout;i++) {
                    System.out.println("==============================");
                    System.out.println("This is a ticket");
                    System.out.println("price : " + price);
                    System.out.println("==============================");
                    balance -= price;
                    total += price;
                }
            }
            else {
                System.out.println("余额不足，请充值！");
            }
        }

        int refund() {
            int result = balance;
            balance = 0;
            return result;
        }

        int getTotal() {
            return total;
        }

        void reset() {
            balance = 0;
            total = 0;
        }

        public static void main(String[] args) {
            TicketMachine ticketMachine = new TicketMachine();
            ticketMachine.setPrice(2);
            ticketMachine.insertMoney(-10);
            System.out.println("balance : " + ticketMachine.getBalance());
            ticketMachine.print();
            ticketMachine.print();
            System.out.println("balance : " + ticketMachine.getBalance());
            System.out.println("refund : " + ticketMachine.refund());

            System.out.println("total : " + ticketMachine.getTotal());
        }

    }
