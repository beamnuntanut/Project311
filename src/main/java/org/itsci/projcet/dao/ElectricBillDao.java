package org.itsci.projcet.dao;

import org.itsci.projcet.model.ElectricBill;
import org.itsci.projcet.model.WaterBill;

public interface ElectricBillDao {

    ElectricBill getElectricBill(int room_billid);

    void saveElectricBill(ElectricBill electricBill);
}
