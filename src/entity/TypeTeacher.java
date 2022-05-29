package entity;

public enum TypeTeacher {
	GS_TS("giao su tien si"),
	PSG_TS("pho giao su tien si"),
	GVC("giang vien chinh"),
	TS("thac si");
	public String value;
	TypeTeacher (String value){
		this.value = value;
	}
}
