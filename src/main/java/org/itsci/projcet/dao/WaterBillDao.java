package org.itsci.projcet.dao;

import org.itsci.projcet.model.WaterBill;

public interface WaterBillDao {
    void saveWaterBill(WaterBill waterBill);
    WaterBill getWaterBill(int id);
    void deleteProduct(int id);
}
