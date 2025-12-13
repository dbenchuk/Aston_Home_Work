public abstract class Animal {
    private String name;
    private boolean isFullness;
    private static int animalsCount = 0;

    Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public void setFullness(boolean status) {
        isFullness = status;
    }

    public static String getAnimalsCount() {
        return "Создано животных: " + animalsCount;
    }
}