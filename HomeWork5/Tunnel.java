import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    protected Semaphore smp;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров и шириной " + Main.CARS_COUNT / 2+ " машины";
        this.smp = new Semaphore(Main.CARS_COUNT / 2, true);
    }


    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronized(this){
                    System.out.println(c.getName() + " закончил этап: " + description);
                    smp.release();}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}