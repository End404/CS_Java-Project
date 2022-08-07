/**
 * 第4章Java虚拟机类加载机制
 *
 */


package demo_JVM_4;

public class NotInit {
    public static class SuperClz{
        static {
            System.out.println("super init");
        }
        public static int value = 123;
    }
    public static class ChildClz extends SuperClz{
        static {
            System.out.println("child init");
        }
    }

    public static void main(String[] args) {
        System.out.println(ChildClz.value);
    }
}
