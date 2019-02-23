/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import jpa.entities.OtnServiceInfo;
import jpa.entities.UserGroup;

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
    //根据环一、环二、环三进行查询
     public List<OtnServiceInfo> findByNetRing(String ring) {
        CriteriaBuilder criteriaBuilder=getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = criteriaBuilder.createQuery();
        Root root=cq.from(OtnServiceInfo.class);
        cq.select(root).where(criteriaBuilder.like(root.get("netRing"), "%"+ring+"%"));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
