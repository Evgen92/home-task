package ht2;

import java.util.Objects;

public class Student extends Person {

    public int course;
    private int a;
    int age;
    protected String discipline;

    public void printName(){
        System.out.println(discipline);
    }

    protected String setDisc(String c) {
        discipline = discipline + " ";
        return discipline;
    }

    private int isA(int b){
        a = b + b;
        return a;
    }

    int isAge (int d, int e){
        if (d > e){
            age = d;
        } else age = e;
        return age;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                a == student.a &&
                age == student.age &&
                discipline.equals(student.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, a, age, discipline);
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", a=" + a +
                ", age=" + age +
                ", discipline='" + discipline + '\'' +
                '}';
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
