import java.util.ArrayList;
import java.util.Arrays;


// Пустой объявленный класс, где G обозначает тип, который будет заменен реальным типом.
public class Generic<G> {

    // Объявляем объект
    private G[] obj;

    //Передаем конструктору ссылку на объект
    public Generic(G[] obj) {
        this.obj = obj;
    }

    // Возвращаем объект типа Т
    public G[] getObj() {
        return obj;
    }

    // Получаем информацию о типе объекта
    public void showType() {
        System.out.println(obj.getClass().getName());
    }

    // Массив в лист
    public ArrayList<G> createArrayList() {
        ArrayList<G> arrayList = new ArrayList<G>(Arrays.asList(obj));
        System.out.println(arrayList);
        return arrayList;
    }

    // Меняем элементы местами
    public void changePositionOfElementsInArray() {
        G x = obj[0];
        obj[0] = obj[1];
        obj[1] = x;
        System.out.println(Arrays.toString(obj));
    }
}
