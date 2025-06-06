/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

/**
 *
 * @author PC
 */
public class Card {

    private Integer id;
    private int status;

    // Constructor không tham số
    public Card() {
    }

    // Constructor đầy đủ tham số
    public Card(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    // Getter và Setter cho id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Card{"
                + "id=" + id
                + ", status=" + status
                + '}';
    }

    // equals và hashCode (tùy chọn)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }

        Card card = (Card) o;

        if (status != card.status) {
            return false;
        }
        return id != null ? id.equals(card.id) : card.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + status;
        return result;
    }
}
