/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fashion.store.entity;

/**
 *
 * @author PC
 */
import java.util.Objects;

public class Inventory {
    private String productId;
    private int quantity;

    public Inventory() {}

    public Inventory(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getter and Setter for productId
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString
    @Override
    public String toString() {
        return "Inventory{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return quantity == inventory.quantity &&
                Objects.equals(productId, inventory.productId);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }
}
