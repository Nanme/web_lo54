package com.service;

import com.entity.Course;
import com.entity.CourseSession;
import com.entity.Location;
import com.repository.CourseDAO;
import com.repository.CourseSessionDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ResearchService {
    private final CourseSessionDAO courseSessionDAO = new CourseSessionDAO();
    private final CourseDAO courseDAO = new CourseDAO();

    //TODO Test it
    public List<Course> FindByKeyword (String keyword) {
        List<Course> courses = courseDAO.getAll();
        List<Course> toReturn = new ArrayList<>();

        for (Course course : courses) {
            if (course.getTitle().contains(keyword)
                && !toReturn.contains(course)) {
                toReturn.add(course);
            }
        }

        return toReturn;
    }

    //TODO Test it
    public List<Course> FindByDate (Date date){
        List<CourseSession> sessions = courseSessionDAO.getAll();
        List<Course> toReturn = new ArrayList<>();
        for(CourseSession session : sessions) {
            /*Check if the date is during the session and if the list does not
              already contain the course */
            if (date.after(session.getStartDate())
                && date.before(session.getEndDate())
                && !toReturn.contains(session.getCourse()))
                toReturn.add(session.getCourse());
        }

        return toReturn;
    }

    //TODO Test it
    public List<Course> FindByLocation (Location loc){
        List<CourseSession> sessions = courseSessionDAO.getAll();
        List<Course> toReturn = new ArrayList<>();
        for(CourseSession session : sessions) {
            if (session.getLocation().equals(loc)
                && !toReturn.contains(session.getCourse()))
                toReturn.add(session.getCourse());
        }

        return toReturn;
    }

    //TODO Test it
    public List<CourseSession> FindByCourse (Course course){
        List<CourseSession> sessions = courseSessionDAO.getAll();
        List<CourseSession> toReturn = new ArrayList<>();

        for(CourseSession session : sessions) {
            if (session.getCourse().equals(course)
                && !toReturn.contains(session))
                toReturn.add(session);
        }

        return toReturn;
    }

}
