package org.itsci.projcet.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Vector;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment")
	private int roomid;

	@NotNull
	private String floor;

	@NotNull
	private String room_type;

	@NotNull
	private List<Users> users;

	@NotNull
	@ManyToOne
	private List<RoomBill> roombill;
	
	public Room() {
		super();
	}

	public Room(int roomid, String floor, String room_type, List<Users> users, List<RoomBill> roombill) {
		super();
		this.roomid = roomid;
		this.floor = floor;
		this.room_type = room_type;
		this.users = users;
		this.roombill = roombill;
	}
	
	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public List<RoomBill> getRoombill() {
		return roombill;
	}

	public void setRoombill(List<RoomBill> roombill) {
		this.roombill = roombill;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public int calRoomcost() {
		if("1".equals(room_type)) {
			return 3000;
		}
		else if("2".equals(room_type)) {
			return 2500;
		}
		return 0;
	}
}
