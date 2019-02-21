/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.OtnServiceInfo;

/**
 *
 * @author Administrator
 */
@Stateless
public class OtnServiceInfoFacade extends AbstractFacade<OtnServiceInfo> {

    @PersistenceContext(unitName = "CsImsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OtnServiceInfoFacade() {
        super(OtnServiceInfo.class);
    }
    
}
