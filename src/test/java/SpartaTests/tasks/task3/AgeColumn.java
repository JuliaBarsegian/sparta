package SpartaTests.tasks.task3;

public class AgeColumn {
    private String age;

    public AgeColumn(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomerAge{");
        sb.append("age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
