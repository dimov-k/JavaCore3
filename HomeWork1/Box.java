import java.util.ArrayList;

public class Box<F extends Fruit>{

    // Объявляем объекты лист и вес
    private ArrayList<F> fruits;
    private float totalWeight;

    public Box() {
        fruits = new ArrayList<>();
    }

    // В контруктор передаем ссылку на лист
    public Box(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    public Box(F fruit) {
        fruits = new ArrayList<>();
        fruits.add(fruit);

    }

    public ArrayList<F> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    public float getTotalWeight() {
        if (fruits.size() != 0) {
            int i = 0;
            totalWeight = fruits.size() * fruits.get(i).getWeight();
        } else {
            System.out.println("We don't have fruits in a box. ");
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return getTotalWeight() == otherBox.getTotalWeight();
    }
    public void replaceAllFruitsToOtherBox(Box<F> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public void addFruit(F fruitToAdd) {
        fruits.add(fruitToAdd);
    }
}