public class HiPlayser extends Thread{
    HiPlayser()
    {
        this.start();
    }

    public void run()
    {

        try {
            while (true) {
                Thread.sleep(10000);
                System.out.println("hello darkness my old friend");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
