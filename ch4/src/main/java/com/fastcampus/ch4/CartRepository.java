package com.fastcampus.ch4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
