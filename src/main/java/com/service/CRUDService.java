package com.service;

import com.entity.Course;
import com.entity.CourseSession;
import com.entity.Location;
import com.repository.ClientDAO;
import com.repository.CourseDAO;
import com.repository.CourseSessionDAO;
import com.repository.LocationDAO;

import java.util.Date;
import java.util.List;

public final class CRUDService {
    private final CourseDAO courseDAO = new CourseDAO();
    private final ClientDAO clientDAO = new ClientDAO();
    private final CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
    private final LocationDAO locationDAO = new LocationDAO();

    public void addCourse(String code, String title) {
        //TODO Write function
    }

    public void addCourseSession(Date startDate, Date endDate, Course course, Location Location) {
        //TODO Write function
    }

    public void addLocation (String city) {
        //TODO Write function
    }

    public void deleteCourse(String code, String title) {
        //TODO Write function
    }

    public void deleteClient(String lastName, String firstName, String address,
                        String email, String phone, CourseSession courseSession) {
        //TODO Write function
    }

    public void deleteCourseSession(Date startDate, Date endDate, Course course,
                               Location location) {
        //TODO Write function
    }

    public void deleteLocation(String city) {
        //TODO Write function
    }

    public List<Location> getLocations() {
        return locationDAO.getAll();
    }
}
