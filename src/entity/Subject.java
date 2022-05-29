package entity;

import java.util.Scanner;

public class Subject {
	public static Scanner sc = new Scanner(System.in);
	private static int autoId = -1;
	private int id;
	private String nameSubject;
	private int totalLessons;
	private int totalTheory;
	private double cost;
	public Subject() {
		if(autoId == -1) {
			autoId = 100;
			id = autoId;
			return;
		}
		this.id = autoId++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameSubject() {
		return nameSubject;
	}
	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}
	public int getTotalLessons() {
		return totalLessons;
	}
	public void setTotalLessons(int totalLessons) {
		this.totalLessons = totalLessons;
	}
	public int getTotalTheory() {
		return totalTheory;
	}
	public void setTotalTheory(int totalTheory) {
		this.totalTheory = totalTheory;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void inputSubject() {
		this.id = Subject.autoId;
		System.out.println("nhap ten mon hoc");
		this.nameSubject = sc.next();
		do{
			System.out.println("nhap tong so tiet nhung khong qua 200 tiet");
			this.totalLessons = sc.nextInt();
			if(this.totalLessons >0 && this.totalLessons <= 200){
				break;
			}
		}while (true);
		System.out.println("nhap tong so tiet ly thuyet");
		this.totalTheory = sc.nextInt();
		System.out.println("nhap muc kinh phi");
		this.cost = sc.nextDouble();
	}
	@Override
	public String toString() {
		return "Subject [  id=" + id + ", nameSubject=" + nameSubject + ", totalLessons="
				+ totalLessons + ", totalTheory=" + totalTheory + ", cost=" + cost + "]";
	}
	
}
