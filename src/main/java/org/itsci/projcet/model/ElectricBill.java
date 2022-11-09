package org.itsci.projcet.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "electric_bill")
public class ElectricBill {
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
	
	public ElectricBill() {
		super();
	}

	public ElectricBill(int billid, Date dates, int last_unit, int current_unit, int amount, double price) {
		super();
		this.billid = billid;
		this.dates = dates;
		this.last_unit = last_unit;
		this.current_unit = current_unit;
		this.amount = amount;
		this.price = price;
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
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
	
	public double calElectricPrice() {
		return calElectricAmount() * 7.0;
	}
	
	public int calElectricAmount() {
		return current_unit - last_unit;
	}
}
