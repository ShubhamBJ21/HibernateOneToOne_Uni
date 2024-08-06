package OneToOne_Uni.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	@OneToOne
	private AdharCard adharCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public AdharCard getAdharCard() {
		return adharCard;
	}
	
	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
}
