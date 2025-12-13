public interface Shape {
    double calculateArea();
    double calculatePerimeter();
    String getFillColor();
    String getBorderColor();

    default void circlePerimetr(double radius){
        System.out.println("default периметр круга: " + 2 * 3.14 * radius);
    }

    default void rectanglePerimetr(double length, double width){
        System.out.println("default периметр прямоугольника: " + (2 * length + 2 * width));
    }

    default void trianglePerimetr(double a, double b, double c){
        System.out.println("default периметр треугольника: " + (a + b + c));
    }
}