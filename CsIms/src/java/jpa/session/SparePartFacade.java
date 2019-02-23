/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SparePart;

/**
 *
 * @author Administrator
 */
@Stateless
public class SparePartFacade extends AbstractFacade<SparePart> {

    @PersistenceContext(unitName = "CsImsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SparePartFacade() {
        super(SparePart.class);
    }
    
}
