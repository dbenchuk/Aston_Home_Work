public class Triangle implements Shape {
    private int aSide;
    private int bSide;
    private int cSide;
    private String fillColor;
    private String borderColor;

    Triangle(int aSide, int bSide, int cSide, String fillColor, String borderColor) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return (aSide * bSide) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return aSide + bSide + cSide;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}