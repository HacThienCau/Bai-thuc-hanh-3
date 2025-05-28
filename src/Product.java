class Product {
    private String name;
    private String imagePath;
    private double price;
    private String description;
    private String brand;

    public Product(String name, String imagePath, double price, String desciption, String brand) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.description = desciption;
        this.brand = brand;
    }

    public String getName(){
        return this.name;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public double getPrice(){
        return this.price;
    }

    public String getDesciption(){
        return this.description;
    }

    public String getBrand(){
        return this.brand;
    }
}