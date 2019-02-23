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
import jpa.entities.UserGroup;

/**
 *
 * @author Administrator
 */
@Stateless
public class UserGroupFacade extends AbstractFacade<UserGroup> {

    @PersistenceContext(unitName = "CsImsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserGroupFacade() {
        super(UserGroup.class);
    }
      //根据名称模糊查询，但root.get("name")使这段代码的通用性降低，因为其他表中的名称字段未必是name. 应该在继承类中实现
    public List<UserGroup> findByNameFromUserGroup(String name) {
        CriteriaBuilder criteriaBuilder=getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = criteriaBuilder.createQuery();
        Root root=cq.from(UserGroup.class);
        cq.select(root).where(criteriaBuilder.like(root.get("groupName"), "%"+name+"%"));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
