import java.lang.reflect.*;
import java.util.*;


public class Main {

        public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
            start(Test1.class);
            System.out.println();
            start(Test2.class);
            System.out.println();
            start(Test3.class);
            System.out.println();
/*            start("Test4"); // exception
            System.out.println();*/
        }

        public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
            Method[] methods = c.getDeclaredMethods();
            int bsCount = 0, asCount = 0;
            List<Method> tests = new ArrayList<>();

            // Проверка на уникальность BeforeSuite и AfterSuite. Добавление тестов в ArrayList
            for (Method o : methods) {
                String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
                if (type.equals("BeforeSuite")) {
                    bsCount++;
                    if (bsCount > 1) throw new RuntimeException("Методы с аннотациями возможно использовать в единственном экземпляре .");
                } else if (type.equals("AfterSuite")) {
                    asCount++;
                    if (asCount > 1) throw new RuntimeException("етоды с аннотациями возможно использовать в единственном экземпляре.");
                } else if (type.equals("Test")) {
                    tests.add(o);
                }
            }

            // Сортируем списки тестов по назначению
            tests.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).value()));

            // Добавление BeforeSuite в начало тестов и AfterSuite в конец.
            for (Method o : methods) {
                String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
                if (type.equals("BeforeSuite")) {
                    tests.add(0, o);
                }
                if (type.equals("AfterSuite")) {
                    tests.add(o);
                }
            }

            // Вывод информации и запуск тестов
            for (Method i : tests) {
                try {
                    System.out.print("(" + i.getDeclaredAnnotation(Test.class).value() + ") ");
                } catch (NullPointerException e) {

                }
                i.invoke(c.newInstance(), null);
            }
        }


        public static void start(String className) {
            try {
                Class<?> c = Class.forName(className);
                Constructor<?> constructor = c.getConstructor(null);
                start(c);
            } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
}
