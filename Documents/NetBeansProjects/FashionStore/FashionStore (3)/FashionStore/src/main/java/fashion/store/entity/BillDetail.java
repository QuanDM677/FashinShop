/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fashion.store.entity;

/**
 *
 * @author PC
 */
public class BillDetail {

    private Long id;
    private Long billId;
    private String productId;
    private double unitPrice;
    private double discount;
    private int quantity;
    private String productName;

    // Constructor không tham số
    public BillDetail() {
    }

    // Constructor đầy đủ tham số (nếu cần thêm drinkName thì bổ sung vào đây)
    public BillDetail(Long id, Long billId, String productId, double unitPrice, double discount, int quantity, String productName) {
        this.id = id;
        this.billId = billId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.productName = productName;
    }

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho billId
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    // Getter và Setter cho drinkId
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Getter và Setter cho unitPrice
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Getter và Setter cho discount
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Getter và Setter cho quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter và Setter cho drinkName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String drinkName) {
        this.productName = drinkName;
    }

    // toString
    @Override
    public String toString() {
        return "BillDetail{"
                + "id=" + id
                + ", billId=" + billId
                + ", drinkId='" + productId + '\''
                + ", unitPrice=" + unitPrice
                + ", discount=" + discount
                + ", quantity=" + quantity
                + ", productName='" + productName + '\''
                + '}';
    }

    // equals và hashCode (tùy chọn)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BillDetail)) {
            return false;
        }

        BillDetail that = (BillDetail) o;

        if (Double.compare(that.unitPrice, unitPrice) != 0) {
            return false;
        }
        if (Double.compare(that.discount, discount) != 0) {
            return false;
        }
        if (quantity != that.quantity) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (billId != null ? !billId.equals(that.billId) : that.billId != null) {
            return false;
        }
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) {
            return false;
        }
        return productName != null ? productName.equals(that.productName) : that.productName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (billId != null ? billId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }

    public double getTotalPrice() {
//        return unitPrice * (1 - discount) * quantity;
        // Nếu muốn làm tròn 2 số thập phân thì:
         double total = unitPrice * (1 - discount) * quantity;
         return Math.round(total * 100.0) / 100.0;
    }
}
