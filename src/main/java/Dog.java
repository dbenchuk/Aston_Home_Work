public class Dog extends Animal {
    private final int RUN_LIMIT = 500;
    private final int SWIM_LIMIT = 10;
    private static int dogsCount = 0;

    Dog(String name) {
        super(name);
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 500)
            System.out.println("Собака " + getName() + " пробежала " + distance + " м.");
        else
            System.out.println("Собака " + getName() + " не может столько пробежать");
    }

    @Override
    public void swim(int distance) {
        if (distance > 0 && distance <= 10)
            System.out.println("Собака " + getName() + " проплыла " + distance + " м.");
        else
            System.out.println("Собака " + getName() + " не может столько проплыть");
    }

    public static String getDogsCount() {
        return "Создано собак: " + dogsCount;
    }
}