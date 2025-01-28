package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date manufactureDatee;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDatee) {
        super(name, price);
        this.manufactureDatee = manufactureDatee;
    }

    public Date getManufactureDatee() {
        return manufactureDatee;
    }

    public void setManufactureDatee(Date manufactureDatee) {
        this.manufactureDatee = manufactureDatee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " (used) ");
        sb.append(String.format("$%.2f", getPrice()));
        sb.append(" (Manufacture date: " + sdf.format(manufactureDatee) + ")");
        return sb.toString();
    }

    

    

}
