/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fashion.store.dao.impl;

import java.util.Date;
import java.util.List;
import fashion.store.dao.RevenueDAO;
import fashion.store.entity.Revenue.ByCategory;
import fashion.store.entity.Revenue.BySummary;
import fashion.store.entity.Revenue.ByUser;
import fashion.store.util.XQuery;

/**
 *
 * @author PC
 */
public class RevenueDAOImpl implements RevenueDAO {

    @Override
    public List<ByCategory> getByCategory(Date begin, Date end) {
        String revenueByCategorySql
                = "SELECT category.Name AS Category, "
                + "   sum(detail.UnitPrice*detail.Quantity*(1-detail.Discount)) AS Revenue,"
                + "   sum(detail.Quantity) AS Quantity,"
                + "   min(detail.UnitPrice) AS MinPrice,"
                + "   max(detail.UnitPrice) AS MaxPrice,"
                + "   avg(detail.UnitPrice) AS AvgPrice "
                + "FROM BillDetails detail "
                + "   JOIN Products product ON product.Id=detail.ProductId"
                + "   JOIN Categories category ON category.Id=product.CategoryId"
                + "   JOIN Bills bill ON bill.Id=detail.BillId "
                + "WHERE bill.Status=1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY category.Name "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(ByCategory.class, revenueByCategorySql, begin, end);
    }

    @Override
    public List<ByUser> getByUser(Date begin, Date end) {
        String revenueByUserSql
                = "SELECT bill.Username AS [User], "
                + "   sum(detail.UnitPrice*detail.Quantity*(1-detail.Discount)) AS Revenue,"
                + "   count(DISTINCT detail.BillId) AS Quantity,"
                + "   min(bill.Checkin) AS FirstTime,"
                + "   max(bill.Checkin) AS LastTime "
                + "FROM BillDetails detail "
                + "   JOIN Bills bill ON bill.Id=detail.BillId "
                + "WHERE bill.Status=1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY bill.Username "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(ByUser.class, revenueByUserSql, begin, end);
    }

    @Override
    public  List<BySummary> getBySummary(Date begin, Date end) {
        String revenueBySummarySql = """
        SELECT
            SUM(detail.UnitPrice * detail.Quantity * (1 - detail.Discount)) AS Revenue,
            SUM(detail.Quantity) AS Quantity,
            COUNT(DISTINCT detail.BillId) AS BillCount,
            MIN(detail.UnitPrice) AS MinPrice,
            MAX(detail.UnitPrice) AS MaxPrice,
            AVG(detail.UnitPrice) AS AvgPrice
        FROM BillDetails detail
        JOIN Bills bill ON bill.Id = detail.BillId
        WHERE bill.Status = 1
          AND bill.Checkout IS NOT NULL
          AND bill.Checkout BETWEEN ? AND ?
        """;
        return XQuery.getBeanList(BySummary.class, revenueBySummarySql, begin, end);
    }
}
