package entity;

import java.util.Scanner;

public class Teacher extends People{
	public static Scanner sc = new Scanner(System.in);
	private static int autoId = -1;
	private int id;
	private TypeTeacher typeteacher;

	public Teacher() {
		if (autoId == -1) {
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

	public TypeTeacher getTypeteacher() {
		return typeteacher;
	}

	public void setTypeteacher(TypeTeacher typeteacher) {
		this.typeteacher = typeteacher;
	}
	
	public void inputTeacher() {
		this.id = Teacher.autoId;
		super.inputPeople();
		System.out.println("nhập trình độ giảng viên");
		System.out.println("1: giáo sư tiến sĩ");
		System.out.println("2: phó giáo sư tiến sĩ");
		System.out.println("3: giảng viên chính");
		System.out.println("4: thạc sĩ");
		int n = 0;
		do {
			n = sc.nextInt();
			if(n >=1 && n <=4) {
				break;
			}
		}while(true);
		switch(n) {
		case 1:
			this.setTypeteacher(typeteacher.GS_TS);
			break;
		case 2:
			this.setTypeteacher(typeteacher.PSG_TS);
			break;
		case 3:
			this.setTypeteacher(typeteacher.GVC);
			break;
		case 4:
			this.setTypeteacher(typeteacher.TS);
			break;
		}
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", typeteacher=" + typeteacher + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getPhone()=" + getPhone() + "]";
	}
	
}
