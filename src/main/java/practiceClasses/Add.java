package practiceClasses;

class Add {
    public  void add(int a, int b) {
        System.out.println(a+b);
    }
    
    public  void add(int a, int b, int c) {
        System.out.println(a+b);
    }


    public static void main(String args[]) {
        Add obj = new Add();
        obj.add(3, 5);
        obj.add(7, 8, 9);
    }
}


