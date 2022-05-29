package service;

import main.MainRun;
import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import entity.TeachingDetail;


import java.util.Scanner;

public class TeachingService {
    public static Scanner sc = new Scanner(System.in);

    public static Teacher inputTeacher(int n) {
        System.out.println("nhap ma giang vien thu " + (n + 1));
        Teacher teacher = null;
        do {
            int id = sc.nextInt();
            for (int i = 0; i < MainRun.teachers.length; i++) {
                if (MainRun.teachers[i] != null && MainRun.teachers[i].getId() == id) {
                    teacher = MainRun.teachers[i];
                    break;
                }
            }
            if (teacher != null) {
                break;
            }
            System.out.println("khong co giang vien nay");
        } while (true);
        return teacher;
    }


    public static TeachingDetail[] inputTeachingDetail() {
        System.out.println("nhap so luong mon hoc");
        int numberSubjec = sc.nextInt();
        TeachingDetail[] teachingDetails = new TeachingDetail[numberSubjec];
        Subject subject = null;
        for (int i = 0; i < numberSubjec; i++) {
            System.out.println("nhap ma mon thu " + (i + 1) + "ma muon phan cong cho giao vien");
            do {
                int idSubject = sc.nextInt();
                for (int j = 0; j < MainRun.subjects.length; j++) {
                    if (MainRun.subjects[i] != null && MainRun.subjects[i].getId() == idSubject) {
                        subject = MainRun.subjects[i];
                        break;
                    }
                }
                if (subject != null) {
                    break;
                }
            } while (true);
            System.out.println("nhap so lop muon phan cong cho giang vien");
            int quantity = 0;
            do {
                System.out.println("giang vien khong day qua 3 lop");
                quantity = sc.nextInt();
                if (quantity >= 1 && quantity <= 3) {
                    break;
                }
            } while (true);
            TeachingDetail teachingDetail = new TeachingDetail(subject, quantity);
            for (int j = 0; j < teachingDetails.length; i++) {
                if (teachingDetails[j] == null) {
                    teachingDetails[j] = teachingDetail;
                    break;
                }
            }
        }
        return teachingDetails;
    }

    public static void save(Teaching teaching) {
        for (int i = 0; i < MainRun.teachings.length; i++) {
            if (MainRun.teachings[i] == null) {
                MainRun.teachings[i] = teaching;
                break;
            }
        }
    }

    public static void inputTeachings() {
        TeacherService teacherService = new TeacherService();
        SubjectService subjectService = new SubjectService();
        if (teacherService.ckeckImpty() == false || subjectService.ckeckImpty() == false) {
            System.out.println("can nhap giang vien va mon hoc truoc khi phan cong");
            return;
        } else {
            System.out.println("nhap so luong giang vien can phan cong");
            int numberTeacher = sc.nextInt();
            for (int i = 0; i < numberTeacher; i++) {
                Teacher teacher = inputTeacher(i);
                TeachingDetail[] teachingDetail = inputTeachingDetail();
                Teaching teaching = new Teaching(teacher, teachingDetail);

                if (totalLesson(teaching) > 200) {
                    System.out.println("giang vien nay khong the day hon 200 tiet phan lai di");
                    continue;
                }
                save(teaching);
            }
        }
    }

    public  void show() {
        for (int i = 0; i < MainRun.teachings.length; i++) {
            if (MainRun.teachings[i] == null) {
                continue;
            }
            System.out.println(MainRun.teachings[i]);
        }
    }

    public static int totalLesson(Teaching teaching) {
        int sum = 0;
        for (int i = 0; i < teaching.getTeachingDetails().length; i++) {
            Subject subject = teaching.getTeachingDetails()[i].getSubject();
            int quantity = teaching.getTeachingDetails()[i].getQuantityClass();
            sum += (subject.getTotalLessons() * quantity);
        }
        return sum;
    }
    public void sort () {
        System.out.println("nhap cach sap xep");
        System.out.println("1: sap xep theo ho ten giang vien");
        System.out.println("2: sap xep theo so tiet day");
        int n = 0;
        do {
            n = sc.nextInt();
            if (n == 1 || n == 2) {
                break;
            }
        } while (true);
        switch (n) {
            case 1:
                for (int i = 0; i < MainRun.teachings.length; i++) {
                    if (MainRun.teachings[i] == null) {
                        continue;
                    }
                    for (int j = i + 1; j < MainRun.teachings.length; j++) {
                        if (MainRun.teachings[j] == null) {
                            continue;
                        }
                        if (MainRun.teachings[i].getTeacher().getName().compareTo(MainRun.teachings[j].getTeacher().getName()) > 0) {
                            Teaching teaching = MainRun.teachings[i];
                            MainRun.teachings[i] = MainRun.teachings[j];
                            MainRun.teachings[j] = teaching;
                        }
                    }
                }
                show();
                break;
            case 2:
                for (int i = 0; i < MainRun.teachings.length; i++) {
                    if (MainRun.teachings[i] == null) {
                        continue;
                    }
                    for (int j = i + 1; j < MainRun.teachings.length; j++) {
                        if (MainRun.teachings[j] == null) {
                            continue;
                        }
                        if(totalLesson(MainRun.teachings[i]) < totalLesson(MainRun.teachings[j])){
                            Teaching teaching = MainRun.teachings[j];
                            MainRun.teachings[j] = MainRun.teachings[i];
                            MainRun.teachings[i] = teaching;
                        }
                    }
                }
                show();
                break;
        }
    }
    public static double money (Teaching teaching) {
        int sum =0 ;
        for (int i = 0; i < teaching.getTeachingDetails().length; i++) {
            int practice = teaching.getTeachingDetails()[i].getSubject().getTotalLessons() - teaching.getTeachingDetails()[i].getSubject().getTotalTheory();
            double cost =  teaching.getTeachingDetails()[i].getSubject().getCost();
            int theory =  teaching.getTeachingDetails()[i].getSubject().getTotalTheory();
            int quantity = teaching.getTeachingDetails()[i].getQuantityClass();
            sum += (cost * theory + 0.7*cost*practice)* quantity;
        }
        return sum;
    }
    public void tableMoney () {
        for (int i = 0; i < MainRun.teachings.length; i++) {
            if(MainRun.teachings[i] == null){
                continue;
            }else {
                System.out.println("id "+MainRun.teachings[i].getTeacher().getId()+ " name "+MainRun.teachings[i].getTeacher().getName() + " salary "+ money(MainRun.teachings[i]));
            }
        }
    }
}
