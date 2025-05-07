package com.oop.examples.encapsulation;

import com.oop.examples.shared.Fotografiable;
import com.oop.examples.shared.Picture;

public class Worker extends Person implements Fotografiable {
    private String jobTitle;
    private double salary;

    // Constructor
    public Worker(Person person, String jobTitle, double salary) {
        super(person.getName(), person.getAge(), person.getEmail());
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // Getters & Setters
    public String getJobTitle() {
        return this.jobTitle;
    }

    public String getSalary() {
        return this.salary;
    }

    Public void setJob(String jobTitle, double salary) {
        setJobTitle(jobTitle);
        setSalary(salary);
    }

    private void setJobTitle(String jobTitle) {
        if (jobTitle != null && !jobTitle.trim().isEmpty()) {
            this.jobTitle = jobTitle;
            return true;
        }
        return false;
    }

    private void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
            return true;
        }
        return false;
    }

    @Override
    public void toString() {
        return "Worker{" +
                "jobTitle='" + getJobTitle() + '\'' +
                ", salary=" + getSalary() + '$/h' +
                '}\n' + super.toString();
    }

    // class methods
    public void trabajar(int horas) {
        System.out.println("Trabajando " + horas + " horas...");
    }

    private void postTrabajo(int horas) {
        System.out.println("Tras trabajar por " + horas + " horas, " + getName() + " ha generado $" + (horas * getSalary()) + ".");
    }
}