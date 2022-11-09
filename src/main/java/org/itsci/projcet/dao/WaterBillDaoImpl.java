package org.itsci.projcet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projcet.model.WaterBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

@Repository
public class WaterBillDaoImpl implements WaterBillDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveWaterBill(WaterBill waterBill) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(waterBill);
    }

    @Override
    public WaterBill getWaterBill(int  room_billid) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select water_billid,dates,last_unit,current_unit,amount,price from water_bill where room_billid =:room_billid';";
        Query<WaterBill> query = session.createQuery(sql, WaterBill.class);
        query.setParameter("room_billid", room_billid);
        WaterBill waterBill = query.getSingleResult();
        return waterBill;
    }
}