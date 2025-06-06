/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

/**
 *
 * @author PC
 */
import java.util.Date;

public class Bill {

    private Long id;
    private String username;
    private Integer cardId;
    private Date checkin = new Date();
    private Date checkout;
    private int status;

    // Constructor không tham số
    public Bill() {
        // checkin đã có giá trị mặc định là new Date()
    }

    // Constructor đầy đủ tham số
    public Bill(Long id, String username, Integer cardId, Date checkin, Date checkout, int status) {
        this.id = id;
        this.username = username;
        this.cardId = cardId;
        this.checkin = (checkin != null) ? checkin : new Date();
        this.checkout = checkout;
        this.status = status;
    }

    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho cardId
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    // Getter và Setter cho checkin
    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = (checkin != null) ? checkin : new Date();
    }

    // Getter và Setter cho checkout
    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    // Getter và Setter cho status
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // toString
    @Override
    public String toString() {
        return "Bill{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", cardId=" + cardId
                + ", checkin=" + checkin
                + ", checkout=" + checkout
                + ", status=" + status
                + '}';
    }

    // equals và hashCode (tùy chọn)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bill)) {
            return false;
        }

        Bill bill = (Bill) o;

        if (status != bill.status) {
            return false;
        }
        if (id != null ? !id.equals(bill.id) : bill.id != null) {
            return false;
        }
        if (username != null ? !username.equals(bill.username) : bill.username != null) {
            return false;
        }
        if (cardId != null ? !cardId.equals(bill.cardId) : bill.cardId != null) {
            return false;
        }
        if (checkin != null ? !checkin.equals(bill.checkin) : bill.checkin != null) {
            return false;
        }
        return checkout != null ? checkout.equals(bill.checkout) : bill.checkout == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (checkin != null ? checkin.hashCode() : 0);
        result = 31 * result + (checkout != null ? checkout.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
    
    public static class Status {
        public static final int Servicing = 0;
        public static final int Completed = 1;
        public static final int Canceled = 2;
    }
}
