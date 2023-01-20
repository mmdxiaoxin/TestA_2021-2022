package work1;

public class Student implements Comparable<Student>{
    private int studentID;
    private String name;
    private int age;
    private String address;

    public Student(int _studentID, String _name, int _age, String _address) {
        this.studentID = _studentID;
        this.name = _name;
        this.age = _age;
        this.address = _address;
    }

    @Override
    public String toString() {
        return "[" + studentID + "," + "\"" +
                name + "\"" + "," + "\"" +
                age + "," + "\"" +
                address + "\"" + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.studentID - o.studentID;
    }
}
