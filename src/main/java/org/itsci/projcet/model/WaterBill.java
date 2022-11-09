package org.itsci.projcet.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "water_bill")
public class WaterBill {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int billid;

    @NotNull
    private Date dates;

    @NotNull
    private int last_unit;

    @NotNull
    private int current_unit;

    @NotNull
    private int amount;

    @NotNull
    private double price;

    @ManyToOne()
    @JoinColumn(name = "roomid")
    private Room room;

    public WaterBill() {
        super();
    }

    public WaterBill(String billid, Date dates, int last_unit, int current_unit, int amount, double price, Room room) {
        super();
        this.billid = billid;
        this.dates = dates;
        this.last_unit = last_unit;
        this.current_unit = current_unit;
        this.amount = amount;
        this.price = price;
        this.room = room;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public int getLast_unit() {
        return last_unit;
    }

    public void setLast_unit(int last_unit) {
        this.last_unit = last_unit;
    }

    public int getCurrent_unit() {
        return current_unit;
    }

    public void setCurrent_unit(int current_unit) {
        this.current_unit = current_unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double calWaterPrice() {
        return calWaterAmount() * 15.0;
    }

    public int calWaterAmount() {
        return current_unit - last_unit;
    }
}
