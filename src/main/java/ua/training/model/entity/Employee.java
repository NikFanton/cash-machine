package ua.training.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ua.training.model.entity.enums.Role;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Employee(String firstName, String lastName, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Employee(Long id, String firstName, String lastName, String login, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
