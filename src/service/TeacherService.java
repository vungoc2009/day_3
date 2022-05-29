package service;

import java.util.Scanner;

import main.MainRun;
import entity.Teacher;

public class TeacherService implements Search {
    public static Scanner sc = new Scanner(System.in);

    public static void saveTeacher(Teacher teacher) {
        for (int i = 0; i < MainRun.teachers.length; i++) {
            if (MainRun.teachers[i] == null) {
                MainRun.teachers[i] = teacher;
                return;
            }
        }
    }


    @Override
    public void create() {
        System.out.println("nhap so luong giao vien moi");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap giao vien thu " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputTeacher();
            saveTeacher(teacher);
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < MainRun.teachers.length; i++) {
            if (MainRun.teachers[i] != null) {
                System.out.println(MainRun.teachers[i]);
            }
            continue;
        }
    }

    @Override
    public boolean ckeckImpty() {
        Teacher teacher = new Teacher();
        for (int i = 0; i < MainRun.teachers.length; i++) {
            if (MainRun.teachers[i] != null) {
                return true;
            }
        }
        return false;
    }


}
