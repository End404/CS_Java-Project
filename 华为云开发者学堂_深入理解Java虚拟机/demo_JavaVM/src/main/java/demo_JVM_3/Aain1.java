/**
 *
 * 第3章Java虚拟机性能监控和故障处理
 *
 */


package demo_JVM_3;

public class Aain1 {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(3000);
                    System.out.println("hello");
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
