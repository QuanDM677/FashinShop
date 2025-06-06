/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.util;

/**
 *
 * @author PC
 */
import java.sql.ResultSet;
import java.util.List;
import poly.cafe.entity.Category;

public class Test {
    public static void main(String[] args) {
        // Thêm mới
        String insertSql = "INSERT INTO Categories (Id, Name) VALUES (?, ?)";
        XJdbc.executeUpdate(insertSql, "C04", "Loại 4");
        XJdbc.executeUpdate(insertSql, "C05", "Loại 5");

        // Truy vấn nhiều bản ghi
        String selectSql = "SELECT * FROM Categories WHERE Name LIKE ?";
        try {
            ResultSet rs = XJdbc.executeQuery(selectSql, "%Loại%");
            while (rs.next()) {
                System.out.println("Id: " + rs.getString("Id") + ", Name: " + rs.getString("Name"));
            }
            rs.getStatement().getConnection().close(); // Đóng kết nối khi xong
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Truy xuất nhiều bản ghi và chuyển đổi sang List<Category>
        List<Category> beans = XJdbc.getBeanList(Category.class, selectSql, "%Loại%");
        for (Category c : beans) {
            System.out.println(c);
        }

        // Truy xuất một bản ghi và chuyển đổi sang Bean
        String singleSql = "SELECT * FROM Categories WHERE Id=?";
        Category bean = XJdbc.getSingleBean(Category.class, singleSql, "C04");
        System.out.println("Single: " + bean);

        // Truy vấn 1 giá trị
        String valueSql = "SELECT max(Id) FROM Categories WHERE Name LIKE ?";
        String id = (String) XJdbc.getValue(valueSql, "%Loại%");
        System.out.println("Max Id: " + id);
    }
}
