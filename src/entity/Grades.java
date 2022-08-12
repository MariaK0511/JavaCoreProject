package entity;

public class Grades {
    private long id;
    private int grade;

    public Grades() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", grade=" + grade +
                '}';
    }
}
