package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Product[] arrProduct = new Product[100];
        int index = 0; // Số lượng sản phẩm đã nhập
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm ");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("Nhập lựa chọn của bạn : ");
            int choise = Integer.parseInt(scanner.nextLine());
            switch (choise){
                case 1:
                    System.out.println("Nhập số lượng sản phẩm cần nhập thông tin");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin sản phẩm thứ: " + (i + 1));
                        arrProduct[index] = new Product();
                        arrProduct[index].inputData(scanner);
                        index++;
                    }
                    break;
                case 2:
                    System.out.println("danh sách các sản phẩm : ");
                    for (int i = 0; i < index; i++) {
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Lợi nhuận : ");
                    for (int i = 0; i < index; i++) {
                        arrProduct[i].calProfit();
                    }
                    System.out.println("đã tính lợi nhuận");
                    break;
                case 4:
                    System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");

                    for (int i = 0; i < index-1; i++) {
                        for (int j = i+1; j < index; j++) {

                            if(arrProduct[i].getProfit()<arrProduct[j].getProfit()){
                                Product temp = arrProduct[i];
                                arrProduct[i]=arrProduct[j];
                                arrProduct[j]=temp;
                            }
                        }
                    }
                    System.out.println("Da sap xep.");
                    break;
                case 5:
                    System.out.println("5. Thống kê các sản phẩm theo giá");
                    System.out.print("Nhap san pham tu gia : ");
                    float fromPrice = Float.parseFloat(scanner.nextLine());
                    System.out.println();
                    System.out.print("san pham den gia : ");
                    System.out.println();
                    float toPrice = Float.parseFloat(scanner.nextLine());
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getExportPrice() >= fromPrice && arrProduct[i].getExportPrice() <= toPrice){
                            arrProduct[i].displayData();
                        }else {
                            System.err.println("Sản phẩm này không tồn tại");
                        }
                    }

                    break;
                case 6:
                    System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
                    System.out.println("Nhập tên sản phẩm cần tìm : ");
                    String name = scanner.nextLine();
                    boolean productNameFouded = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().equals(name)) {
                            arrProduct[i].displayData();
                            productNameFouded = true;
                        }
                    }
                        if (!productNameFouded){
                            System.err.println("Không tìm thấy sản phẩm có tên: "+name);
                        }

                    break;
                case 7:
                    System.out.println("7. Nhập sản phẩm");
                    System.out.println("Nhập tên sản phẩm cần tìm : ");
                    String addProductID = scanner.nextLine();
                    System.out.println("Nhập số lượng sản phẩm nhập thêm");
                    int addQuantity = Integer.parseInt(scanner.nextLine());
                    boolean foundInput = false;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductID().equals(addProductID)){
                            arrProduct[i].setQuantity(arrProduct[i].getQuantity() + addQuantity);
                            foundInput = true;
                            break;
                        }else {
                            System.err.println("Sản phẩm không tồn tại.");
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("8. Bán sản phẩm");
                    System.out.print("Nhập tên sản phẩm : ");
                    String sellProductName = scanner.nextLine();
                    System.out.print("Nhập số lượng sản phẩm muốn bán : ");
                    int sellQuantity = Integer.parseInt(scanner.nextLine());
                    boolean productFound = false; // Biến kiểm tra xem sản phẩm có tồn tại hay không

                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().equals(sellProductName)) {
                            if (arrProduct[i].isStatus()) {
                                if (arrProduct[i].getQuantity() >= sellQuantity) {
                                    arrProduct[i].setQuantity(arrProduct[i].getQuantity() - sellQuantity);
                                    productFound = true;
                                    System.out.println("Bán sản phẩm thành công.");
                                    System.out.println("Sản phẩm còn lại : "+arrProduct[i].getQuantity());
                                } else {
                                    System.err.println("Sản phẩm không đủ số lượng để bán.");
                                    productFound = true;
                                    break;
                                }
                            } else {
                                System.err.println("Sản phẩm không được bán.");
                                productFound = true;
                                break;
                            }
                        }
                    }

                    if (!productFound) {
                        System.err.println("Sản phẩm không tồn tại.");
                    }
                    break;
                case 9:
                    System.out.println("Nhập mã sản phẩm cần cập nhật trạng thái:");
                    String statusEditId = scanner.nextLine();
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductID().equals(statusEditId)) {
                            arrProduct[i].setStatus(!arrProduct[i].isStatus());
                            System.out.println(arrProduct[i].isStatus());
                        }
                    }
                    System.out.println("Đã cập nhật");
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn lại các lựa chọn từ 1-10");
            }
        }while(true);
    }
}
