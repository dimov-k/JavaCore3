import java.util.concurrent.Phaser;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private static Phaser phaser;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, Phaser phaser) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.phaser = phaser;
        this.phaser.register();

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            this.phaser.arriveAndAwaitAdvance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            synchronized(this){
                this.phaser.arrive();
                if (this.phaser.getPhase()== race.getCountStage() && !race.getFINISH()){
                    race.setFINISH(this);
                    System.out.println(race.getCar_WINNER().getName() + " WIN");
                }
            }
        }
    }
}