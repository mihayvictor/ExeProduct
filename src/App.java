import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            System.out.println("Product #" + (i + 1) + " data: " );
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            
            System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Customd fee: ");
                sc.nextLine();
                double customsfee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsfee));
            }
            else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                Date date = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, date));
            }else{
                list.add(new Product(name, price));
            }
        }
        sc.close();

        for (Product product : list) {
            System.out.println(product.priceTag());
        }
    }
}
