public class Main {
    public static void main(String[] args) {
        Product product_1 = new Product("Box", "01.12.2025", "BigTech",
                "Japan", 15.99, "Ready to ship");

        Product[] productsArray = new Product[5];

        Park park = new Park("1", "Gomel");

        Park.AttractionInfo firstAttraction = park.new AttractionInfo("Tornado",
                "08:00-20:00", 20.99);

        Park.AttractionInfo secondAttraction = park.new AttractionInfo("Wheel",
                "08:00-18:00", 12.50);

        System.out.println("\nTask_1");

        product_1.getProductInfo();

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, "Ready to ship");
        productsArray[1] = new Product("iPhone 16", "01.05.2025",
                "Apple Corp.", "China", 4900, "Ready to ship");
        productsArray[2] = new Product("Xiaomi A2", "15.10.2024",
                "Xiaomi Corp.", "China", 2750, "Ready to ship");
        productsArray[3] = new Product("Samsung S12", "01.02.2023",
                "Samsung Corp.", "Korea", 4200, "Ready to ship");
        productsArray[4] = new Product("iPhone 17", "01.02.2025",
                "Apple Corp.", "China", 6500, "Ready to ship");

        System.out.println("\nTask_2");

        for (Product arr : productsArray) {
            System.out.println("***********");
            arr.getProductInfo();
        }

        System.out.println("\nTask_3");

        firstAttraction.showAttractionInfo();
        secondAttraction.showAttractionInfo();
    }
}