package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public final class Location implements Serializable {
    private Integer id;
    private String city;

    public Location() {
    }

    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    @Id
    @GeneratedValue
    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public String getCity() { return this.city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        return city != null ? city.equals(location.city) : location.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
