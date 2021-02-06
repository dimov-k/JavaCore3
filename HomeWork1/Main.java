public class Main {

    public static void main(String[] args) {

        //Создаем ссылку и объект типа gen и все упоковываем
        Generic<String> catsNames = new Generic<String>(new String[]{"Ева", "Матроскин"});
        Generic<Integer> catsAges = new Generic<Integer>(new Integer[]{4, 8});
        Generic<Double> catsWeights = new Generic<Double>(new Double[]{3.4, 9.2});

        //Смотрим на тип
        System.out.println("\nВыводим массивы которые у нас есть: ");
        catsNames.showType();
        catsAges.showType();
        catsWeights.showType();

        //Создаем листы
        System.out.println("\nСоздаем список массивов с элементами:");
        catsNames.createArrayList();
        catsAges.createArrayList();
        catsWeights.createArrayList();

        //Меняем местами
        System.out.println("\nСоздаем список массивов с меняющими местами элементами:");
        catsNames.changePositionOfElementsInArray();
        catsAges.changePositionOfElementsInArray();
        catsWeights.changePositionOfElementsInArray();



        //Создаем коробку для яблок и создаем яблоки
        Box<Apple> appleBox = new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Apple a4 = new Apple();

        // Кидаем яблоки в коробку
        appleBox.addFruit(a1);
        appleBox.addFruit(a2);
        appleBox.addFruit(a3);

        System.out.println("\nВес коробки с яблоками составляет: " + appleBox.getTotalWeight());

        //Создаем коробку для апельсинов и создаем апельсины
        Box<Orange> orangeBox = new Box<>();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();

        // Кидаем апельсины в коробку
        orangeBox.addFruit(o1);
        orangeBox.addFruit(o2);
        orangeBox.addFruit(o3);

        System.out.println("Вес коробки с апельсинами составляет: " + orangeBox.getTotalWeight());
        System.out.println("Сравниваем вес коробок " + appleBox.compare(orangeBox));

        // Создаем новую пустую коробку и закидываем туда яблоки
        Box<Apple> newAppleBox = new Box<>();
        appleBox.replaceAllFruitsToOtherBox(newAppleBox);

        //Создадим еще одно яблоко и закинем его в новую коробку и потом посмотрим вес
        Apple a5 = new Apple();
        newAppleBox.addFruit(a4);
        System.out.println("Общий вес новой коробки для яблок составляет " + newAppleBox.getTotalWeight());
    }
}