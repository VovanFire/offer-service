package com.fire.offer.offerservice.dao;

import com.fire.offer.offerservice.model.User;

public interface UserDao extends GenericDao<User>{
    User findOneByEmail (String email);
}

