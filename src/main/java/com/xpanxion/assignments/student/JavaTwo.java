package com.xpanxion.assignments.student;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
public class JavaTwo {
    private interface DataAccess{
        Person getPerson(int id);
    }
    private class Repository implements DataAccess{
        private Hashtable<Integer, Person> people=new Hashtable<Integer, Person>();
        public Repository(){
            people.put(1,new Person(1, "John", "Doe"));
        }
        public Person getPerson(){
            return people.get(1);
        }
        public Person getPerson(int id){
            if(!people.containsKey(id)) throw new IllegalArgumentException("No person at this id.");
            else{
                return people.get(id);
            }
        }
    }
    private class Person{
        private int id;
        private String first, last;
        public Person(int id, String first, String last){
            this.id=id; this.first=first; this.last=last;
        }
        public String getFirst(){
            return this.first;
        }
        public String getLast(){
            return this.last;
        }
        public int getId(){
            return this.id;
        }
        public void setFirst(String first){
            this.first=first;
        }
        public void setLast(String last){
            this.last=last;
        }
        public String toString(){
            return String.format("Person{id=%d, firstName='%s', lastName='%s'}", this.id, this.first, this.last);
        }
    }
    /* 
    private class Product{
        private int id; private String name; private double cost;
        public Product(int id, String name, double cost){
            this.id=id; this.name=name; this.cost=cost;
        }
        public int getId(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public double getCost(){
            return this.cost;
        }
    }
    private class Invoice{
            private int id;
            ArrayList<Product> manifest = new ArrayList<Product>();
            public Invoice(int id){
                this.id=id;
            }
            public void addProduct(Product product){
                manifest.add(product);
            }
            public double getTotalCost(){
                double total=0.0;
                for(Product p : manifest){
                    total+=p.getCost();
                }
                return total;
            }
        }
*/
private abstract class Base{
    private int id;
    public Base(int id){
        this.id = id;
        System.out.println("Base constructor called.");
    }
}
private class Product extends Base{
        private int id; private String name; private double cost;
        public Product(int id, String name, double cost){
            super(id); this.name=name; this.cost=cost;
        }
        public int getId(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public double getCost(){
            return this.cost;
        }
    }
    private class Invoice extends Base{
            private int id;
            ArrayList<Product> manifest = new ArrayList<Product>();
            public Invoice(int id){
                super(id);
            }
            public void addProduct(Product product){
                manifest.add(product);
            }
            public double getTotalCost(){
                double total=0.0;
                for(Product p : manifest){
                    total+=p.getCost();
                }
                return total;
            }
        }
private class Calculator{
        private ArrayList<String> memory = new ArrayList<String>();
        private int first,second,result;
        private String operator;
        public void start(){
            Scanner myScanner = new Scanner(System.in);
            boolean done = false;
            String firstString;
            while(!done){
                System.out.println("Enter first number:");
                firstString=myScanner.next();
                if(firstString.equals("done")){
                    for(String o:memory){
                            System.out.println(o);
                        }
                        myScanner.close();
                        return;
                }
                else{
                    first = Integer.parseInt(firstString);
                }
                System.out.println("Enter second number:");        
                second=myScanner.nextInt();
                System.out.println("Enter operation (add, sub,mul,div)");
                operator = myScanner.next();
                char op;
                switch(operator){
                    case("add"):    
                        op='+';
                        result = first+second;
                        memory.add(String.format("%d %c %d = %d", first, op, second, result));
                        break;
                    case("sub"):
                        op='-';
                        result = first-second;
                        memory.add(String.format("%d %c %d = %d", first, op, second, result));
                        break;
                    case("mul"):
                        op='*';
                        result = first*second;
                        memory.add(String.format("%d %c %d = %d", first, op, second, result));
                        break;
                    case("div"):
                        op='/';
                        if(second==0) throw new IllegalArgumentException("cannot divide by 0.");
                        result = first/second;
                        memory.add(String.format("%d %c %d = %d", first, op, second, result));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator.");
                }
                System.out.println("Result: "+result);
        }
            }
}
public class Cat{
        private String name;
        public Cat(String name){
            this.name=name;
        }
        public String getName(){
            return this.name;
        }
        public String toString(){
            return String.format("Cat{name='%s'}", this.name);
        }
    }
    public void ex1(){
        Scanner scanner;
        String input;
        String[] details;
        int id; String first,last;
        ArrayList<Person> people = new ArrayList<Person>();
        while(true){
            scanner = new Scanner(System.in);
            System.out.print("Enter Person: ");
            input = scanner.nextLine();
            if(input.matches("\s*done\s*")){
                scanner.close();
                break;
            }
            details = input.split("\s*,*\s+,*");
            id = Integer.parseInt(details[0]);
            first = details[1]; last = details[2];
            people.add(new Person(id,first,last));
        }
        for(var p:people){
            System.out.println(p.toString());
        }
    }    
    public void ex2(){
        Scanner scanner;
        int id;
        Hashtable<Integer,Person> table = new Hashtable<Integer,Person>();
        table.put(1, new Person(1, "Peter", "Jones"));
        table.put(2, new Person(1, "John", "Smith"));
        table.put(3, new Person(1, "Mary", "Jane"));
        String option = "";
        while(true){
            System.out.print("Enter Person ID: ");
            scanner = new Scanner(System.in);
            option = scanner.next();
            if(option.matches("[0-9]+") && table.containsKey(Integer.parseInt(option))){
                id=Integer.parseInt(option);
                System.out.println(table.get(id).toString());
            }
            else if(option.equals("done")){
                scanner.close(); 
                break;}
            else{
                System.out.println("Enter a valid id.");
            }
        }
    }
    public void ex3(){
        var invoice =  new Invoice(1);
        invoice.addProduct(new Product(111,"Mustard", 2.00));
        invoice.addProduct(new Product(222,"Ketchup", 3.00));
        invoice.addProduct(new Product(333,"Franks Hot Sauce", 4.00));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(invoice.getTotalCost()));
    }
    public void ex4(){
        var invoice =  new Invoice(1);
        invoice.addProduct(new Product(111,"Mustard", 2.00));
        invoice.addProduct(new Product(222,"Ketchup", 3.00));
        invoice.addProduct(new Product(333,"Franks Hot Sauce", 4.00));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(invoice.getTotalCost()));
    }
    public void ex5(){
        var repository = new Repository();
        var p = repository.getPerson();
        System.out.println(p);
    }
    public void ex6(){
        Calculator calc = new Calculator();
        calc.start();
    }
    public void ex7(){
        var personList = Arrays.asList(
        new Person(1, "Peter", "Jones"),
        new Person(2, "John", "Smith"),
        new Person(3, "Sue", "Anderson")
        );
        // TODO: YOUR CODE HERE...
        var newPersonList = personList.stream().map(person -> new Person(person.getId(), person.getFirst(), "xxx")).toList();
        for (Person p : newPersonList) {
            System.out.println(p);
        }
    }
    public void ex8(){
        var personList = Arrays.asList(
        new Person(1, "Charlie", "Jones"),
        new Person(2, "Zoey", "Smith"),
        new Person(3, "Adam", "Anderson")
);  
    personList.sort((person1, person2)-> person1.getFirst().compareToIgnoreCase(person2.getFirst()));
// TODO: Your code here

for (Person p : personList) {
    System.out.println(p);
}
    }
    public void ex9(){
        var personList = Arrays.asList(
        new Person(1, "Charlie", "Jones"),
        new Person(2, "Zoey", "Smith"),
        new Person(3, "Adam", "Anderson")
            );
        ArrayList<Person> filteredList = new ArrayList<Person>();
        for(Person p : personList){
            if(p.getLast().equals("Smith")) filteredList.add(p);
        }
        // TODO: Your code here

        for (Person p : filteredList) {
            System.out.println(p);
        }
    }
    
    public void ex10(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Alice"));
        cats.add(new Cat("Bob"));
        cats.add(new Cat("Charlie"));
        cats.add(new Cat("Dan"));
        while(!cats.isEmpty()){
            System.out.println(cats.toString());
            cats.removeFirst();
        }
    }
}
