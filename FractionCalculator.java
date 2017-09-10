import java.util.Scanner;
import java.io.*;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
class FractionCalculator {
    public static void main(String[] arguments) throws IOException
    {
        Scanner reader = new Scanner(System.in); 
        //InputReader reader=new InputReader(input);
        String s;
        char ops;
        int num, den;
        BufferedReader br;
        String [] numbers=new String[2];
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q.");
        br = new BufferedReader(new InputStreamReader(System.in));
        Fraction result=new Fraction();
        Fraction frac1, frac2;
        String display="";
        while(true){
            System.out.println("Enter your fractions in the form as a/b where a and b are integers.");
            System.out.println("Please enter an operation: (+, -, *, /, = or type Q to quit)");
            s=getOperation(br);
            ops = s.charAt(0);
            if(ops=='Q' || ops=='q')break;
            
            frac1=getFraction(br);
            frac2=getFraction(br);
            
            switch(ops){
                case '+':
                result=frac1.add(frac2);
                 display=frac1.toString()+ops+frac2.toString()+"="+result.toString();
                break;
                case '-':
                result=frac1.subtract(frac2);
                display=frac1.toString()+ops+frac2.toString()+"="+result.toString();
                break;
                case '/':
                result=frac1.divide(frac2);
                 display=frac1.toString()+ops+frac2.toString()+"="+result.toString();
                break;
                case '*':
                result=frac1.multiply(frac2);
                 display=frac1.toString()+ops+frac2.toString()+"="+result.toString();
                break;
                case '=':
                boolean res=frac1.equals(frac2);
                display=frac1.toString()+ops+frac2.toString()+"="+res;
            }//switch
            System.out.println(display);
            System.out.println("................................................");
        }//while
        System.out.println("Process finished with exit code 0.");
    }//main

    public static Fraction getFraction(BufferedReader br) throws IOException {
                 
           System.out.print("Please enter a fraction (a/b) or an interger (a): ");
           String s=br.readLine(); 
           while(validFraction(s)==false){                
                System.out.print("Invalid fraction. Please enter a/b or a where a and b are integers and b is not zero: ");
                s=br.readLine();
            }
            //System.out.println("String is:"+s);
            Fraction frac;
            int num=0, den=1;
            if(s.indexOf("/")>0){
            String [] numbers=s.split("/");
            num=Integer.parseInt(numbers[0]);
            den=Integer.parseInt(numbers[1]);
            frac=new Fraction(num,den);
            }
            else
            {
                num=Integer.parseInt(s);
                frac=new Fraction(num);
            }   
            System.out.println("Fraction is: "+ frac.toString());
            return frac; 
    }
    public static boolean validFraction(String s){
           //System.out.println("Testing "+s+" "+ s.matches("^\\D+$")+" "+s.matches("^/"));
           if(s.matches("^\\D+$")==false){
               return true;
           }  
           return false;
    }
    public static String getOperation(BufferedReader br) throws IOException {
         String s;
           do {
                s = br.readLine();
                
                if(s.equals("q") || s.equals("Q"))break;
                if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("="))break; 
                System.out.print("Invalid input. (+, -, *, /, = or type Q to quit): ");
            }while(true);
        return s;
    }
}//class
   