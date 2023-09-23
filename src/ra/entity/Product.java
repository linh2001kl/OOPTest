package ra.entity;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;
    //2. Constructor:
    //default Constructor
    public Product(){
    }
    //Constructor khởi tạo tất cả thông tin san pham

    public Product(String productID, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }
    // Get/Set:

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //3. Methods:
    public void inputData(Scanner scanner, Product[] arrProduct, int currentIndex, int numberOfProducts){
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.print("Nhập mã sản phẩm : ");
            this.productID = scanner.nextLine();
            System.out.print("Nhập tên sản phẩm : ");
            this.productName = scanner.nextLine();
            System.out.print("Nhập giá nhập : ");
            this.importPrice = Float.parseFloat(scanner.nextLine());
            System.out.print("Nhập giá xuất : ");
            this.exportPrice = Float.parseFloat(scanner.nextLine());
            System.out.print("Nhập số lượng sản phẩm : ");
            this.quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập mô tả sản phẩm : ");
            this.descriptions = scanner.nextLine();
            System.out.print("Nhập trạng thái sản phẩm : ");
            this.status = Boolean.parseBoolean(scanner.nextLine());
            Product product = new Product(productID,productName,importPrice,exportPrice,profit,quantity,descriptions,status);
            arrProduct[currentIndex] = product;
            currentIndex++;
        }

    }
    public void inputData(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm: ");
        this.productID = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.print("Nhập giá nhập (import price): ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.print("Nhập giá xuất (export price): ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());


        System.out.print("Nhập số lượng: ");
        this.quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái (true - Đang bán, false - Không bán): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("Product ID: %s - Tên sản phẩm: %s \n" , this.productID,this.productName);
        System.out.printf("Giá nhập: %f - Giá xuất: %f - Lợi nhuận: %f \n" , this.importPrice,this.exportPrice,this.profit);
        System.out.printf("Mô tả: %s - Số lượng: %d - Trạng thái: %s\n" , descriptions,quantity,(status ? "Đang bán" : "Không bán"));
    }

    public void calProfit() {
        //tự động tính vào nhập liệu vào data của arrProduct
        this.profit = this.exportPrice - this.importPrice;
    }
}
