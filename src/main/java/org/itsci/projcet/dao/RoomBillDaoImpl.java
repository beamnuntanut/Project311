package org.itsci.projcet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projcet.model.RoomBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

@Repository
public class RoomBillDaoImpl implements RoomBillDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RoomBill> getRoomBills(int roomid) {
        Session session = sessionFactory.getCurrentSession();
        Query<RoomBill> query = session.createQuery("from RoomBill where roomid = :roomid", RoomBill.class);
        query.setParameter("roomid", roomid);
        List<RoomBill> RoomBills = query.getResultList();
        return RoomBills;
    }

    @Override
    public void saveRoomBill(RoomBill RoomBill) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(RoomBill);
    }
    @Override
    public RoomBill getRoomBill(int id) {
        Session session = sessionFactory.getCurrentSession();
        RoomBill RoomBill = session.get(RoomBill.class, id);
        return RoomBill;
    }
    @Override
    public void deleteRoomBill(int RoomBillId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from room_bill where id =:RoomBillId ");
        query.setParameter("RoomBillId", RoomBillId);
        query.executeUpdate();
    }
}