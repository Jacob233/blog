package concurrency.test;

public class ThreadReturnTest {

    public String test(final boolean flag) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if (flag) {
                        System.out.println("return flag:" + flag);
                        return;
                    }

                    System.out.println("flag:" + flag);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        String temp = "temp";
        return temp;
    }

    public static void main(String[] args) {
        String result = new ThreadReturnTest().test(true);
        System.out.println("finished,result=" + result);
    }
}
