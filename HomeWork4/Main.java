package HomeWork4;

public class Main {

    public static void main(String[] args) {
        Streams s = new Streams();
            new Thread(() -> s.printA()).start();
            new Thread(() -> s.printB()).start();
            new Thread(() -> s.printC()).start();
        }
    }

