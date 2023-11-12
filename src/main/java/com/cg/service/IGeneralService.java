package com.cg.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <E, Long>{
    List<E> findAll();
    Optional<E> findById(Long id);
    void save(E e);
    void deleted(Long id);
}
