package service;

import java.util.Scanner;

import main.MainRun;
import entity.Subject;

public class SubjectService implements Search{
	public static Scanner sc = new Scanner(System.in);
	public static void saveSubject (Subject subject) {
		for(int i =0 ; i < MainRun.subjects.length ; i++) {
			if(MainRun.subjects[i] == null) {
				MainRun.subjects[i] = subject;
				return;
			}
		}
	}


	@Override
	public void create() {
		System.out.println("nhap so luong mon hoc");
		int n = sc.nextInt();
		for(int i =0 ; i < n ; i++) {
			System.out.println("nhap mon hoc thu " +(i+1));
			Subject subject = new Subject();
			subject.inputSubject();
			saveSubject(subject);
		}
	}

	@Override
	public void show() {
		for(int i =0 ; i < MainRun.subjects.length ; i++) {
			if(MainRun.subjects[i] == null) {
				continue;
			}
			System.out.println(MainRun.subjects[i]);
		}
	}

	@Override
	public boolean ckeckImpty() {
		for(int i =0 ; i < MainRun.subjects.length ; i++){
			if(MainRun.teachers[i] != null){
				return  true;
			}
		}
		return false;
	}
}
