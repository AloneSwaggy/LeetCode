/**
 * @author admin
 * @version 1.0.0
 * @ClassName superTest.java
 * @Description TODO
 * @createTime 2023年12月06日 20:14:00
 */
class SuperClass {
    private int n;

    SuperClass() {
        System.out.println("SuperClass()");
    }

    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}

// SubClass 类继承
class SubClass extends SuperClass {
    private int n;
//
//        SubClass(){ // 自动调用父类的无参数构造器
//            System.out.println("SubClass");
//        }

//        public SubClass(int n){
//            super(300);  // 调用父类中带有参数的构造器
//            System.out.println("SubClass(int n):"+n);
//            this.n = n;
//        }
}

// SubClass2 类继承
class SubClass2 extends SuperClass {
    private int n;

    SubClass2() {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n) { // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):" + n);
        this.n = n;
    }
}

//    public  class superTest {
//        public static void main (String[] args){
//            System.out.println("------SubClass 类继承------");
//            SubClass sc1 = new SubClass();
////            SubClass sc2 = new SubClass(100);
//            System.out.println("------SubClass2 类继承------");
//            SubClass2 sc3 = new SubClass2();
//            SubClass2 sc4 = new SubClass2(200);
//
//    }
class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    //    重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
    //重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
    public void move() {
        System.out.println("狗可以跑和走");
    }

    public void bark() {
        System.out.println("狗可以吠叫");
    }
}

class TestDog {
    public static void main(String[] args) {
        Animal a = new Animal(); // Animal 对象
        Dog b = new Dog(); // Dog 对象

        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法
        b.bark();
    }
}

class Overloading {
    public int test() {
        System.out.println("test1");
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a, String s) {
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "returntest4";
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1, "test3"));
        System.out.println(o.test("test4", 1));
    }
}

enum Color {
    RED, GREEN, BLUE;

    // 构造函数
    private Color() {
        System.out.println("Constructor called for : " + this.toString());
    }

    public void colorInfo() {
        System.out.println("Universal Color");
    }
}

class Test {
    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println(c1);
        c1.colorInfo();
    }
}


