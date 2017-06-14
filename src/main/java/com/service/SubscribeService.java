package com.service;

import com.entity.Client;
import com.entity.CourseSession;
import com.repository.ClientDAO;

public final class SubscribeService {
    private final ClientDAO clientDAO = new ClientDAO();

    //TODO Test it
    public void SubscribeToSession (String firstName, String lastName,
                                    String address, String email, String phone,
                                    CourseSession session){
        Client subscriber = new Client(null, lastName, firstName, address, email,
                                        phone, session);
        clientDAO.add(subscriber);
    }
}
