package org.lilmoon.data;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private static long idCounter = 0;

    private long id;
    private String name;
    private String phoneNumber;
    private int experience;

    public Employee(String name, String phoneNumber, int experience) {
        this.id = ++idCounter;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && experience == employee.experience && Objects.equals(name, employee.name) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, experience);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                '}';
    }


    @Override
    public int compareTo(Employee o) {
        return Long.compare(this.id, o.getId())
                - this.name.compareTo(o.name)
                - this.phoneNumber.compareTo(o.phoneNumber)
                - (Integer.compare(this.experience, o.getExperience()));
    }
}
