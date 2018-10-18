public class TimePlayser extends Thread{
    static private long startTime;

    TimePlayser(long startTime)
    {
        this.startTime = startTime;
        this.start();
    }
    public void run()
    {
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println(System.currentTimeMillis() - startTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
