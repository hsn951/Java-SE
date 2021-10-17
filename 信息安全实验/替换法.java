@author hsn
@2021.9.27
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    private static DecimalFormat df = new DecimalFormat("0.000");
    private static int[] letters = new int[26];   //字母表
    private static int[] letterNum = new int[26];   //字母频数数组
    private static List<Character> list = new ArrayList<Character>(); //密文集合
    public static void main(String[] args) throws IOException {

        //给字母表数组赋初值
        for(int i = 0;i < 26;i++) {
            letters[i] = 'A' + i;
        }
        String filename = "D:\\data.txt";
        FileReader filereader = new FileReader(filename);
        Reader fr = new FileReader(filename);
        int c = fr.read();
        while(c!=-1) {
            if(c>='A'&&c<='Z')
            letterNum[c-65]++;
            //System.out.print((char)(c));
            list.add((char)c);
            c = fr.read();
        }
        swap(list,'C','E');
        //update();
        swap(list,'A','T');
        swap(list,'I','O');
        swap(list,'M','F');
       exhaust();
        for (int i:letters) {
            System.out.print((char)i+"\t");
        }
        System.out.println();
        for (int i:letterNum) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int i:letterNum) {
            System.out.print(df.format(i/4.83)+"%"+"\t");
        }
        fr.close();
        filereader.close();
    }
    //替换函数
    public static void swap(List list,char letter1,char letter2) {
        //扫描密文，交换字母
        for(int i = 0;i < list.size();i++) {
            if ((char) list.get(i) >= 'A' && (char) list.get(i) <= 'Z') {
                if (list.get(i).equals(letter1)) {
                    list.set(i, letter2);
                    continue;
                } else if (list.get(i).equals(letter2)) {
                    list.set(i, letter1);

                }
            }
        }
    }
    //穷举函数
    public static void exhaust() {
        //穷举法
        for(int i = 0;i<26;i++) {
            for (char ch : list) {
                if (ch <= 'Z' && ch >= 'A') {
                    if (ch + i > 90)
                        System.out.print((char) ((ch + i) % 90 + 65));
                    else
                        System.out.print((char) (ch + i));
                }else {
                    System.out.print(ch);
                }
            }

            System.out.println();
            System.out.println();
        }
    }
    //更新字母出现频率
    public static void update() {
        //清空字母频数数组
        for(int i = 0;i<letterNum.length;i++)
            letterNum[i] = 0;
        for(char c:list) {
            if(c<='Z'&&c>='A') {
                letterNum[c-65]++;
            }
        }
        for (int i:letterNum) {
            System.out.print(df.format(i/4.83)+"%"+"\t");
        }
    }

}

