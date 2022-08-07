/**
 * 第2章 Java虚拟机垃圾回收
 * 引用计数
 */


package demo_JVM_2;

public class RefCountGc {
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];
    public Object instance = null;

    public static void main(String[] args) {
        RefCountGc objA = new RefCountGc();
        RefCountGc objB = new RefCountGc();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }
}
