package com.fire.offer.offerservice.dao;

import com.fire.offer.offerservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDao extends GenericDao<User>{
    User findOneByEmail (String email);
}

