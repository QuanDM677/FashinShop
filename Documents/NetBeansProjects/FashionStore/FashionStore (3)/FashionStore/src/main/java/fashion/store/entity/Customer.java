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

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String address;
    private boolean enabled = true;

    public Customer() {}

    public Customer(String id, String name, String phone, String address, boolean enabled) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.enabled = enabled;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for enabled
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return enabled == customer.enabled &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(address, customer.address);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, address, enabled);
    }
}
