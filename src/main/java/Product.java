public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private String status;

    Product(String name, String productionDate, String manufacturer, String countryOfOrigin,
            double price, String status) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.status = status;
    }

    public void getProductInfo() {
        System.out.println("Name: " + name + "\n" + "Production Date: " + productionDate + "\n" +
                "Manufacturer: " + manufacturer + "\n" + "Country of origin: " + countryOfOrigin + "\n" +
                "Price: " + price + "\n" + "Status: " + status);
    }
}