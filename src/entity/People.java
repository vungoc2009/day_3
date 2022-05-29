package entity;

import java.util.Scanner;

public class People {
	public static Scanner sc = new Scanner(System.in);
	
	private String name;
	private String address;
	private String phone;
	public People(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public People() {
		super();
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void inputPeople () {
		System.out.println("nhập tên giáo viên");
		this.name = sc.next();
		System.out.println("nhập địa chỉ giáo viên");
		this.address = sc.next();
		System.out.println("nhập số điện thoại");
		this.phone = sc.next();
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
