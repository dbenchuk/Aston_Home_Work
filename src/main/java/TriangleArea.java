public class TriangleArea {
    public static double triangleArea(int a, int h) {
        double area;

        if (a > 0 && h > 0)
            area = (double)(a * h) / 2;
        else
            throw new IllegalArgumentException("Значение a и h должны быть положительными");

        return area;
    }
}