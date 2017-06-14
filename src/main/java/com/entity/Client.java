package com.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public final class Client implements Serializable {
    private Integer id;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String phone;
    private CourseSession courseSession;

    public Client() {
    }

    public Client(Integer id, String lastName, String firstName, String address, String email, String phone,
                  CourseSession courseSession) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.courseSession = courseSession;
    }

    @Id
    @GeneratedValue
    public Integer getId() { return this.id; }
    public void setId(Integer id) {this.id = id; }

    @Column(name = "last_name")
    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column(name = "first_name")
    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAddress() { return this.address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return this.phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_session_id")
    public CourseSession getCourseSession() { return courseSession; }
    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", courseSession=" + courseSession +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        return courseSession != null ? courseSession.equals(client.courseSession) : client.courseSession == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (courseSession != null ? courseSession.hashCode() : 0);
        return result;
    }
}
