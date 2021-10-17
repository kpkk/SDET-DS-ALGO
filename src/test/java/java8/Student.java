package java8;

import java.util.List;

public class Student {
    private String name;
    private String gender;
    private double gpa;
    private int gradeLevel;
    private List<String> activities;

    public Student(String name, String gender, double gpa, int gradeLevel, List<String>activities){
        this.name=name;
        this.gradeLevel=gradeLevel;
        this.gender=gender;
        this.gpa=gpa;
        this.activities=activities;
    }

    public Student() {
        
    }

    public Student(String s) {
        this.name=s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString(){
        return "Student{"+ "name:"+name+", gpa:"+gpa+", gradeLevel:"+gradeLevel+", gender:"+gender+", Activities:"+activities+"}";
    }

}
