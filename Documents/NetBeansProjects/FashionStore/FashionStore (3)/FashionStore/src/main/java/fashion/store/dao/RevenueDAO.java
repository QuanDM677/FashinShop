/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fashion.store.dao;

import java.util.Date;
import java.util.List;
import fashion.store.entity.Revenue;

/**
 *
 * @author PC
 */
public interface RevenueDAO {

    /**
     * Truy vấn doanh thu từng loại theo khoảng thời gian
     *
     * @param begin thời gian bắt đầu
     * @param end thời gian kết thúc
     * @return kết quả truy vấn
     */
    List<Revenue.ByCategory> getByCategory(Date begin, Date end);

    /**
     * Truy vấn doanh thu từng nhân viên theo khoảng thời gian
     *
     * @param begin thời gian bắt đầu
     * @param end thời gian kết thúc
     * @return kết quả truy vấn
     */
    List<Revenue.ByUser> getByUser(Date begin, Date end);


    List<Revenue.BySummary> getBySummary(Date begin, Date end);
}
