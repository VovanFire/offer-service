package com.fire.offer.offerservice.dao.impl;

import com.fire.offer.offerservice.dao.OfferCreatorDao;
import com.fire.offer.offerservice.model.OfferCreator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("offerCreatorDao")
public class HbOfferCreatorDaoImpl extends AbstractDao<OfferCreator> implements OfferCreatorDao{
    @Autowired
    public HbOfferCreatorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<OfferCreator> getEntityType() {
        return OfferCreator.class;
    }
}
