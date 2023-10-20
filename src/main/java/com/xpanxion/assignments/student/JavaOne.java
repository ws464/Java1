package com.xpanxion.assignments.student;
import java.util.Scanner;
public class JavaOne {
    //
    // Constructors
    //
    private Scanner myScanner;
    public JavaOne() {myScanner = new Scanner(System.in);}

    //
    // Public methods
    //

    public void ex1() {
        System.out.println("Enter your name:");
        String name = myScanner.nextLine();
        System.out.println(this.toUpper(name));
    }

    public void ex2() {
        System.out.println("Enter a string");
        char[] input = myScanner.nextLine().toCharArray();
        int count = 0;
        for(char c : input){
            if((int)c >64 && (int)c<91){
                count++;
            }
        }
        System.out.println("# of uppercase letters: "+count);
    }

    public void ex3() {
        System.out.println("Enter a string:");
        String input = myScanner.nextLine();
        String[] words = input.split("\s+");
        for(int i=0; i<words.length; i++){
            if(i%2==0) words[i] = this.toUpper(words[i]);
        }
        String ret = "";
        for(String w : words){
            ret+=w+" ";
        }
        System.out.println(ret);
    }

    public void ex4() {
        System.out.println("Enter a string:");
        char[] input = myScanner.nextLine().toCharArray();
        boolean pal = true;
        int len = input.length;
        for(int i = 0; i<input.length/2; i++){
            if(input[i]!=input[len-i-1]){
                pal=false;
                break;
            }
        }
        System.out.println(pal);
    }

    public void ex5() {
        System.out.println("Enter a string:");
        String input = myScanner.nextLine();
        char[] inputChar = toUpper(input).toCharArray();
        int vowel = 0; int cont = 0;
        for(char c : inputChar){
            if((int)c >= 65 && (int)c <= 90){
                if((int)c == 65 || (int)c == 69 || (int)c == 73 || (int)c == 79 || (int)c == 85 || (int)c == 89){
                    vowel++;
                }
                else cont++;
            }
        }
        System.out.println("Number of vowels: "+vowel+"\nNumber of consonants: "+cont);
    }

    public void ex6() {
        int f, s;
        System.out.println("Enter first number:");
        f=myScanner.nextInt();
        System.out.println("Enter second number:");        
        s=myScanner.nextInt();
        System.out.println("Result: "+(f+s));
    }

    public void ex7() {
        int first,second,result;
        char op;
        System.out.println("Enter first number:");
        first=myScanner.nextInt();
        System.out.println("Enter second number:");        
        second=myScanner.nextInt();
        System.out.println("Enter operation (\'+\',\'-\',\'*\',\'/\'')");
        op = myScanner.next().charAt(0);
        switch(op){
            case('+'):
                result = first+second;
                break;
            case('-'):
                result = first-second;
                break;
            case('*'):
                result = first*second;
                break;
            case('/'):
                if(second==0) throw new IllegalArgumentException("cannot divide by 0.");
                result = first/second;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
        System.out.println("Result: "+result);
    }

    public void ex8() {
        Scanner scanner = new Scanner(System.in);
        int area, width, length;
        double price;
        String input;
        String[] dimensions;
        area=0;
        System.out.print("Enter price per square feet:");
        price = scanner.nextDouble();
        while(true){
            scanner = new Scanner(System.in);
            System.out.print("Enter room dimensions (width x height):");
            input = scanner.nextLine();
            if(input.matches("\s*done\s*")){
                scanner.close();
                break;
            }
            dimensions = input.split("\s*x\s*");
            width = Integer.parseInt(dimensions[0]);
            length = Integer.parseInt(dimensions[1]);
            area += width*length;
        }
        System.out.println("Total cost: $"+area*price);
        scanner.close();
    }

    public void ex9() {
        int random = (int)(Math.random()*5)+1;
        int guess = -1;
        while(true){
            System.out.println("Enter a number:");
            guess = myScanner.nextInt();
            if(guess == random){
                System.out.println("You guessed it!!!!");
                break;
            }
            else{
                System.out.println("Try again...");
            }
        }
    }
    public void ex10() {
        System.out.println("Enter a string:");
        String input = myScanner.nextLine();
        String[] words = input.split("\s+");
        for(String w : words){
            char[] letters = w.toCharArray();
            for(int i=0; i<letters.length; i++){
                for(int j=0; j<i; j++){
                    System.out.print(" ");
                }
                System.out.print(letters[i]+"\n");
            }
        }
    }

    //
    // Private helper methods
    //
    private String toUpper(String s){
        char[] name = s.toCharArray();
        for(int i = 0; i<name.length; i++){
            char c = name[i];
            if((int)c >96 && (int)c<123){
                name[i] = (char)((int)c-32);
            }
        }
        return new String(name);
    }
}
