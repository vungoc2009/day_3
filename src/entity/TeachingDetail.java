package entity;

public class TeachingDetail {
    private Subject subject;
    private int quantityClass;

    public TeachingDetail(Subject subject) {
        this.subject = subject;
    }

    public TeachingDetail(Subject subject, int quantityClass) {
        this.subject = subject;
        this.quantityClass = quantityClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getQuantityClass() {
        return quantityClass;
    }

    public void setQuantityClass(int quantityClass) {
        this.quantityClass = quantityClass;
    }

    @Override
    public String toString() {
        return "TeachingDetail{" +
                "subject=" + subject +
                ", quantityClass=" + quantityClass +
                '}';
    }
}
