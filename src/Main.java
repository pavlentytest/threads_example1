public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("+");
        MyThread thread2 = new MyThread("-");
        thread1.start();
        thread2.start();
        Thread.sleep(5000);
        thread1.flag = false;
        // thread1.join(); // ждет завершение потока
        test("1 Stopped!");
    }

    public static final Object KEY = new Object();
    public static void test(String message) {

        //synchronized(KEY) {
            try {
                System.out.print("[");
                Thread.sleep(500);
                System.out.print(message);
                Thread.sleep(500);
                System.out.print("]");
           //     KEY.notify(); // возобновляем поток, наход. в режиме ожидания
          //      KEY.wait(); // выставляем в режим ожидания
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //}
    }
}
class MyThread extends Thread {
    String mess;
    boolean flag = true;
    MyThread(String m){
        mess = m;
    }
    @Override
    public void run() {
        while(flag) {
            Main.test(this.mess);
        }
    }
}