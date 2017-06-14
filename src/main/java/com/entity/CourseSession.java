package com.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "course_session")
public final class CourseSession implements Serializable {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Course course;
    private Location location;

    public CourseSession() {
    }

    public CourseSession(Integer id, Date startDate, Date endDate, Course course, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.location = location;
    }

    @Id
    @GeneratedValue
    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate() { return this.startDate; }
    public void setStartDate(Date startDate) {this.startDate = startDate; }


    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndDate() { return this.endDate; }
    public void setEndDate(Date endDate) {this.endDate = endDate; }

    @ManyToOne
    @PrimaryKeyJoinColumn
    public Course  getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @ManyToOne( cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Location getLocation() { return location; }
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", course=" + course +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSession that = (CourseSession) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
