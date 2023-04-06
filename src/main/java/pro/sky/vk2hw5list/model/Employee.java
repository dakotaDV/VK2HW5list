package pro.sky.vk2hw5list.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {



@JsonProperty("firstName")
    private String name;
    private String LastName;


    public Employee(String name, String lastName) {
        this.name = name;
        this.LastName = lastName;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return LastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(LastName, employee.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, LastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", Имя='" + name + '\'' +
                ", Фамилия='" + LastName + '\'' +

                '}';
    }
}


