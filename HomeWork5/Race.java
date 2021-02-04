import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    private Boolean FINISH = false;
    private Car car_WINNER;
    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Boolean getFINISH(){
        return FINISH;
    }

    public int getCountStage(){
        return stages.size();
    }

    public Car getCar_WINNER(){
        return car_WINNER;
    }
    public void setFINISH(Car car){
        this.FINISH = true;
        this.car_WINNER = car;
    }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}