public class Main {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();
        System.out.println("第一个实例值：" + singleton1.getValue());

        Singleton singleton2 = Singleton.getInstance();
        System.out.println("第二个实例值：" + singleton2.getValue());

        if(singleton1 == singleton2) {
            System.out.println("singleton1 与 singleton2 是相同的实例");
        } else {
            System.out.println("singleton1 与 singleton2 是不同的实例");
        }

    }
}
