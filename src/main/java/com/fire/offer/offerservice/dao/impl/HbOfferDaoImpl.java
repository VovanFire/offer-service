package com.fire.offer.offerservice.dao.impl;

import com.fire.offer.offerservice.dao.OfferDao;
import com.fire.offer.offerservice.model.Offer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("offerCreatorDao")
public class HbOfferDaoImpl extends AbstractDao<Offer> implements OfferDao {
    @Autowired
    public HbOfferDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<Offer> getEntityType() {
        return Offer.class;
    }
}
