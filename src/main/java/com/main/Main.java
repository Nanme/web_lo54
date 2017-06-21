package com.main;

import com.entity.Course;
import com.service.CRUDService;

/**
 * Created by Daniel Paredes on 7/4/2017.
 */
public class Main {
    public static void main(String[] args) {

        CRUDService nuevocurso = new CRUDService();

        nuevocurso.addCourse("LO02","Anglais");



    }
}
