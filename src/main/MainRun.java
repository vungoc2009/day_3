package main;

import java.util.Scanner;

import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import service.SubjectService;
import service.TeacherService;
import service.TeachingService;

public class MainRun {
    public static Scanner sc = new Scanner(System.in);
    public static Teacher[] teachers = new Teacher[100];
    public static Subject[] subjects = new Subject[100];
    public  static Teaching [] teachings = new Teaching[100];

    public static void main(String[] args) {
        TeacherService a = new TeacherService();
        SubjectService b = new SubjectService();
        TeachingService c = new TeachingService();

        while (true) {
            System.out.println("moi ban nhap lua chon");
            System.out.println("1: nhap danh sach mon hoc ");
            System.out.println("2: in danh sach mon hoc");
            System.out.println("3: nhap danh sach giao vien va in");
            System.out.println("4: in danh sach giang vien");
            System.out.println("5: phan cong giang vien");
            System.out.println("6: sap xep danh sach ke khai giang vien");
            System.out.println("7: bang luong");
            int n = 0;
            do {
                n = sc.nextInt();
                if (n >= 1 && n <= 7) {
                    break;
                }
            } while (true);
            switch (n) {
                case 1:
                    b.create();
                    break;
                case 2:
                    b.show();
                    break;
                case 3:
                    a.create();
                    break;
                case 4:
                    a.show();
                    break;
                case 5:
                    c.inputTeachings();
                    c.show();
                    break;
                case 6:
                    c.sort();
                    break;
                case 7:
                    c.tableMoney();
                    break;
            }
        }
    }
}
