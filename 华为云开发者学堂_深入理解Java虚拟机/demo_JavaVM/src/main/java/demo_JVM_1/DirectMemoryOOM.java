
/**
 * 第1章 Java虚拟机内存管理
 * 堆外内存溢出
 *
 */


package demo_JVM_1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
//            Unsafe.allocateMemory(_1MB);
        }
    }
}
