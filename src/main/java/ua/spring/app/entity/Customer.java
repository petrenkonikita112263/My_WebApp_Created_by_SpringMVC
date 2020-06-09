package ua.spring.app.entity;

import java.util.Objects;

public class Customer {

    private int id;
    private String userName;
    private String password;
    private String role;
    private int enable;

    public Customer() {
    }

    public Customer(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", userName='" + userName + '\''
                + ", password='" + password + '\''
                + ", role='" + role + '\''
                + ", enable=" + enable + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            Customer customer = (Customer) o;
            return id == customer.id &&
                    enable == customer.enable &&
                    Objects.equals(userName, customer.userName) &&
                    Objects.equals(password, customer.password) &&
                    Objects.equals(role, customer.role);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, userName, password, role, enable);
        return (27 + result * 3) / 4;
    }
}
