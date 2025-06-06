/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

/**
 *
 * @author PC
 */
public class BillDetail {

    private Long id;
    private Long billId;
    private String drinkId;
    private double unitPrice;
    private double discount;
    private int quantity;
    private String drinkName;

    // Constructor không tham số
    public BillDetail() {
    }

    // Constructor đầy đủ tham số (nếu cần thêm drinkName thì bổ sung vào đây)
    public BillDetail(Long id, Long billId, String drinkId, double unitPrice, double discount, int quantity, String drinkName) {
        this.id = id;
        this.billId = billId;
        this.drinkId = drinkId;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.drinkName = drinkName;
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
    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
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
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    // toString
    @Override
    public String toString() {
        return "BillDetail{"
                + "id=" + id
                + ", billId=" + billId
                + ", drinkId='" + drinkId + '\''
                + ", unitPrice=" + unitPrice
                + ", discount=" + discount
                + ", quantity=" + quantity
                + ", drinkName='" + drinkName + '\''
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
        if (drinkId != null ? !drinkId.equals(that.drinkId) : that.drinkId != null) {
            return false;
        }
        return drinkName != null ? drinkName.equals(that.drinkName) : that.drinkName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (billId != null ? billId.hashCode() : 0);
        result = 31 * result + (drinkId != null ? drinkId.hashCode() : 0);
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (drinkName != null ? drinkName.hashCode() : 0);
        return result;
    }

    public double getTotalPrice() {
        return (unitPrice - discount) * quantity;
    }
}
