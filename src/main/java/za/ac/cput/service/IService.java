/*
IRepository.java
Generic Repository Interface
Author: Ashton Mondreo Petersen (220219494)
 */

package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

    List<T> findAll();
}
