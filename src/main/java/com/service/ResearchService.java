package com.service;

import com.entity.Course;
import com.entity.CourseSession;
import com.entity.Location;
import com.repository.CourseSessionDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ResearchService {
    private final CourseSessionDAO courseSessionDAO = new CourseSessionDAO();

    /**
     * Return the session filtered by a keyword in the title of the course corresponding.
     * @param keyword
     * @return
     */
    public List<CourseSession> FindByKeyword (String keyword) {
        List<CourseSession> courseSessions = courseSessionDAO.getAll();
        List<CourseSession> toReturn = new ArrayList<>();

        for (CourseSession session : courseSessions) {
            if (session.getCourse().getTitle().contains(keyword)
                && !toReturn.contains(session)) {
                toReturn.add(session);
            }
        }

        return toReturn;
    }

    /**
     * Return the list of the course session which contains {@param date}.
     * @param date
     * @return
     */
    public List<CourseSession> FindByDate (Date date){
        List<CourseSession> sessions = courseSessionDAO.getAll();
        List<CourseSession> toReturn = new ArrayList<>();
        for(CourseSession session : sessions) {
            /*Check if the date is during the session and if the list does not
              already contain the course */
            if (date.after(session.getStartDate())
                && date.before(session.getEndDate())
                && !toReturn.contains(session))
                toReturn.add(session);
        }

        return toReturn;
    }

    /**
     * Return the list of the session which is located at {@param loc}
     * @param loc
     * @return
     */
    public List<CourseSession> FindByLocation (Location loc){
        List<CourseSession> sessions = courseSessionDAO.getAll();
        List<CourseSession> toReturn = new ArrayList<>();
        for(CourseSession session : sessions) {
            if (session.getLocation().equals(loc)
                && !toReturn.contains(session))
                toReturn.add(session);
        }

        return toReturn;
    }

    /**
     * Return the list of session filtered by {@param course}
     * @param course
     * @return
     */
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
