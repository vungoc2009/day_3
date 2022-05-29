package entity;

import java.util.Arrays;

public class Teaching {
    private Teacher teacher;
    private TeachingDetail [] teachingDetails;

    public Teaching() {
    }

    public Teaching(Teacher teacher, TeachingDetail[] teachingDetails) {
        this.teacher = teacher;
        this.teachingDetails = teachingDetails;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + teacher +
                ", teachingDetails=" + Arrays.toString(teachingDetails) +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeachingDetail[] getTeachingDetails() {
        return teachingDetails;
    }

    public void setTeachingDetails(TeachingDetail[] teachingDetails) {
        this.teachingDetails = teachingDetails;
    }


}
