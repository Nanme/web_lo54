package com.repository;

import java.util.List;

/**
 * Created by renaud on 12/05/2017.
 */
public interface IDAO<T> {

    List<T> getAll();
    T getFromId(Object id);
    void add(T toAdd);
    void delete(T toDelete);
}
