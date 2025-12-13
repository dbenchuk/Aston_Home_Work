public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик");
        Dog sharik = new Dog("Шарик");
        Bowl bowl = new Bowl(7,2);
        Cat[] cats = new Cat[5];
        Circle circle = new Circle(5,"Black", "Red");
        Rectangle rectangle = new Rectangle(2,4, "Blue", "White");
        Triangle triangle = new Triangle(2,3,5, "Green", "Yellow");

        cats[0] = new Cat("Кузя");
        cats[1] = new Cat("Лёлик");
        cats[2] = new Cat("Пушок");
        cats[3] = new Cat("Ляля");
        cats[4] = new Cat("Мурзик");

        barsik.run(50);
        barsik.swim(5);

        sharik.run(15);
        sharik.swim(5);

        System.out.println(Animal.getAnimalsCount());
        System.out.println(Cat.getCatsCount());
        System.out.println(Dog.getDogsCount());

        bowl.addFood(10);

        for (int i = 0; i < cats.length; i++) {
            bowl.feed(cats[i]);
        }

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        System.out.println(triangle.calculateArea());
        System.out.println(triangle.calculatePerimeter());

        circle.circlePerimetr(7);
        rectangle.rectanglePerimetr(5,3);
        triangle.trianglePerimetr(2,3,5);
    }
}
