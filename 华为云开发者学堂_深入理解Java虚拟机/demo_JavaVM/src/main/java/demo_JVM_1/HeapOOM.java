/**
 * 第1章 Java虚拟机内存管理
 * Java堆溢出
 *
 */


package demo_JVM_1;

import java.util.ArrayList;

//    Java堆溢出

public class HeapOOM {
    static class OOMOdject{}
    public static void main(String[] args) {
        ArrayList<OOMOdject> list = new ArrayList<>();
        while (true){
            list.add(new OOMOdject());
        }
    }
}
