public class Bowl {
    private int amountOfFood;
    private int portionOfFood;

    Bowl(int amount, int portion) {
        amountOfFood = amount;
        portionOfFood = portion;
    }

    public void feed(Animal animal) {
        if ((amountOfFood -= portionOfFood) < 0)
            System.out.println("В миске мало еды. " + animal.getName() + " не поел(а)");
        else {
            animal.setFullness(true);
            System.out.println(animal.getName() + " поел(а)");
        }
    }

    public void addFood(int x) {
        System.out.println("В миску добавлено " + x + " еды");
        amountOfFood += x;
    }
}