package bishi.toutiao;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    static String six5 = "66666";
    static String dot4Six1 = "....6";
    static String six1Dot4 = "6....";
    static String sixDot3Six = "6...6";
    static String dot2SixDot2 = "..6..";
    static String dot5 = ".....";
    static String sixdotsixdotsix = "6.6.6";
    static String dotSixDotSixDot = ".6.6.";
    static String space = "..";
//    static String dot2SixDot2 = ".6.6.";
    static HashMap<Character, String[]> map;
//    String[] s0 = {"66666", "6...6", "6...6", "6...6", "66666"};
//    String[] s1 = {"....6", "....6", "....6", "....6", "....6"};
//    String[] s2 = {"66666", "....6", "....6", "....6", "....6"};

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
//        String foo = "40+2";
//        System.out.println(engine.eval(foo));

        Scanner scanner = new Scanner(System.in);
        initial();
        int len = Integer.parseInt(scanner.nextLine());
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = scanner.nextLine();
        }
        for (String s : strs
             ) {
            long result = (Long) engine.eval(s);
            print(""+result);
        }
    }

    private static void initial() {
        map = new HashMap<>();
        map.put('0', new String[]{six5, sixDot3Six, sixDot3Six, sixDot3Six, six5});
        map.put('1', new String[]{dot4Six1, dot4Six1, dot4Six1, dot4Six1, dot4Six1});
        map.put('2', new String[]{six5, dot4Six1, six5, six1Dot4, six5});
        map.put('3', new String[]{six5, dot4Six1, six5, dot4Six1, six5});
        map.put('4', new String[]{sixDot3Six, sixDot3Six, six5, dot4Six1, dot4Six1});
        map.put('5', new String[]{six5, six1Dot4, six5, dot4Six1, six5});
        map.put('6', new String[]{six5, six1Dot4, six5, sixDot3Six, six5});
        map.put('7', new String[]{six5, dot4Six1, dot4Six1, dot4Six1, dot4Six1});
        map.put('8', new String[]{six5, sixDot3Six, six5, sixDot3Six, six5});
        map.put('9', new String[]{six5, sixDot3Six, six5, dot4Six1, six5});
//        map.put('+', new String[]{dot2SixDot2, dot2SixDot2, six5, dot2SixDot2, dot2SixDot2});
//        map.put('-', new String[]{dot5, dot5, six5, dot5, dot5});
//        map.put('*', new String[]{sixdotsixdotsix, dotSixDotSixDot, dot2SixDot2, dotSixDotSixDot, sixdotsixdotsix});
    }


    public static void print(String line) {
        if (line == null || line.length() == 0) {
            return;
        }
        int n = line.length();
        for (int i = 0; i < 5; i++) {
//            五行
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map.get(line.charAt(j))[i]);
                if (j != n - 1) {
                    sb.append(space);
                }
            }

            System.out.println(sb);
        }
    }


    public static long getResult(String str){
        if(str==null || str.length()==0)
            return -1;
        Stack<Long> num=new Stack<>();
        Stack<Character> ch=new Stack<>();
        int i=0;
        int k=0;
        long num1=-1;
        long num2=-1;
        boolean end=false;
        while(i<str.length()){
            if(str.charAt(i)=='*'){
                int j=i+1;
                i++;
                while (i<str.length()){
                    if(str.charAt(i)=='*'||str.charAt(i)=='-'||str.charAt(i)=='+'){
                        num2=Long.valueOf(str.substring(j,i));
                        break;
                    }
                    i++;
                }
                if(i==str.length()){
                    num2=Long.valueOf(str.substring(j,i));
                    end=true;
                }
                num1= Long.valueOf(str.substring(k,j-1));
                num.push(num1*num2);
            }else if(str.charAt(i)=='-'){
                num1=Long.valueOf(str.substring(k,i));
                num.push(num1);
                k=i;
                ch.push('-');
            }else if(str.charAt(i)=='+'){
                num1=Long.valueOf(str.substring(k,i));
                num.push(num1);
                k=i;
                ch.push('+');
            }
            i++;
        }
        if(!end){
            num1=Long.valueOf(str.substring(k,i));
            num.push(num1);
        }

        while (!ch.isEmpty()){
            char c=ch.pop();
            num1=num.pop();
            num2=num.pop();
            if(c=='-'){
                num.push(num2-num1);
            }else{
                num.push(num2+num1);
            }
        }
        return num.peek();



    }
}
