package org.itsci.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projcet.dao.ElectricBillDao;
import org.itsci.projcet.model.ElectricBill;
import org.itsci.projcet.model.WaterBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class ElectricBillDaoImpl implements ElectricBillDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElectricBill getElectricBill(int  room_billid) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select water_billid,dates,last_unit,current_unit,amount,price from electric_bill where room_billid =:room_billid';";
        Query<ElectricBill> query = session.createQuery(sql, ElectricBill.class);
        query.setParameter("room_billid", room_billid);
        ElectricBill electricBill = query.getSingleResult();
        return electricBill;
    }

    @Override
    public void saveElectricBill(ElectricBill electricBill) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(electricBill);
    }
}