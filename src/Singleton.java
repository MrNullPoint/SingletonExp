public class Singleton {

    private int value;

    private static Singleton singleton = new Singleton();

    // 设置成了 private 保证不能从外部调用构造函数进行 new
    // 输出生成了一个实例测试 Singleton 类的行为
    private Singleton() {
        this.value = (int) (10 * Math.random());
        System.out.println("生成了一个实例");
    }

    // 用于外部获取这个实例
    public static Singleton getInstance() {
        return singleton;
    }

    public int getValue() {
        return value;
    }

}
