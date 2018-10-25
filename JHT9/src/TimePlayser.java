import java.time.LocalTime;

public class TimePlayser extends Thread{
    private LocalTime startTime;

    TimePlayser(long startTime)
    {
        this.startTime = LocalTime.now();
        this.start();
    }
    public void run()
    {
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println(LocalTime.from(startTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
