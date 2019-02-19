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
    public List< OtnServiceInfo> findRange(int[] range) {
       CriteriaBuilder criteriaBuilder=getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = criteriaBuilder.createQuery();
        Root root=cq.from(OtnServiceInfo.class);
        cq.select(root).orderBy(criteriaBuilder.asc(root.get("frequency")),criteriaBuilder.asc(root.get("lineProperty")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
}
