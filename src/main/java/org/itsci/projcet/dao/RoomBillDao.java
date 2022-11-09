package org.itsci.projcet.dao;

import org.itsci.projcet.model.RoomBill;

import java.util.List;

public interface RoomBillDao {
    List<RoomBill> getRoomBills(int roomid);
    void saveRoomBill(RoomBill RoomBill);
    RoomBill getRoomBill(int id);
    void deleteRoomBill(int RoomBillId);
}
