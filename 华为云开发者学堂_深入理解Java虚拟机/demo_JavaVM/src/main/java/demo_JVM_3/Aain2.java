/**
 *
 * 第3章Java虚拟机性能监控和故障处理
 *
 */



package demo_JVM_3;

import java.util.ArrayList;

public class Aain2 {
    static class OOMObject{
        public byte[] placeHolder = new byte[64*1024];
    }
    public static void fillHeap(int num) throws InterruptedException{
        ArrayList<OOMObject> oomObjects = new ArrayList<>();
        for (int i=0; i<num; i++){
            Thread.sleep(50);
            oomObjects.add(new OOMObject());
        }
        System.gc();
    }
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
