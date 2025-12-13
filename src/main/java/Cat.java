public class Cat extends Animal {
    private final int RUN_LIMIT = 200;
    private static int catsCount = 0;

    Cat(String name) {
        super(name);
        setFullness(false);
        catsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 200)
            System.out.println("Кот " + getName() + " пробежал " + distance + " м.");
        else
            System.out.println("Кот " + getName() + " не может столько пробежать");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + getName() + " не умеет плавать");
    }

    public static String getCatsCount() {
        return "Создано котов: " + catsCount;
    }
}
