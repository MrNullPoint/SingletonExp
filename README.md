一天一个设计模式 - Singleton

Singleton 模式

这个世界中有很多是唯一的存在，Singleton 模式就是把这种唯一性体现出来。映射到程序中就是只生成一个实例，当然你可以通过逻辑控制只调用一次 new Something() ，如果我们想确保任何情况下都绝对只有一个实例，想表现出只存在一个实例的话，我们就会用到 Singleton 模式。

举个栗子

我们现在是上帝角色，设计一个只能唯一存在实例的类：Singleton，设置其构造函数为 private 保证其不能从外部进行 new 操作，在设置只返回一个实例的静态方法 getInstance() 来获取它的实例。

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

我们现在来测试一下，用 Singleton 生成的实例是不是都是唯一的。

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

结果：

    生成了一个实例
    第一个实例值：5
    第二个实例值：5
    singleton1 与 singleton2 是相同的实例

从结果中我可以看到 Singleton 类只进行了一次初始化行为，换句话说也就是在第一次调用 getInstance() 的时候，static 的 singleton 字段被初始化，生成了唯一的实例。

代码地址：https://github.com/MrNullPoint/SingletonExp

解惑

什么情况下我们要用 Singleton

当我们程序中会出现多个实例，实例之间可能会存在影响，为了放放心心回家过年，哦不对，为了平平安安地编程，我们就可以设置这样一个确保只有一个实例产生的限制。