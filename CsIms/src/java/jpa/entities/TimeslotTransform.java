/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "timeslot_transform")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeslotTransform.findAll", query = "SELECT t FROM TimeslotTransform t")
    , @NamedQuery(name = "TimeslotTransform.findByZte", query = "SELECT t FROM TimeslotTransform t WHERE t.zte = :zte")
    , @NamedQuery(name = "TimeslotTransform.findByHuawei", query = "SELECT t FROM TimeslotTransform t WHERE t.huawei = :huawei")
    , @NamedQuery(name = "TimeslotTransform.findByTug3", query = "SELECT t FROM TimeslotTransform t WHERE t.tug3 = :tug3")
    , @NamedQuery(name = "TimeslotTransform.findByTug2", query = "SELECT t FROM TimeslotTransform t WHERE t.tug2 = :tug2")
    , @NamedQuery(name = "TimeslotTransform.findByTu12", query = "SELECT t FROM TimeslotTransform t WHERE t.tu12 = :tu12")})
public class TimeslotTransform implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zte")
    private Integer zte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "huawei")
    private int huawei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tug3")
    private int tug3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tug2")
    private int tug2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tu12")
    private int tu12;

    public TimeslotTransform() {
    }

    public TimeslotTransform(Integer zte) {
        this.zte = zte;
    }

    public TimeslotTransform(Integer zte, int huawei, int tug3, int tug2, int tu12) {
        this.zte = zte;
        this.huawei = huawei;
        this.tug3 = tug3;
        this.tug2 = tug2;
        this.tu12 = tu12;
    }

    public Integer getZte() {
        return zte;
    }

    public void setZte(Integer zte) {
        this.zte = zte;
    }

    public int getHuawei() {
        return huawei;
    }

    public void setHuawei(int huawei) {
        this.huawei = huawei;
    }

    public int getTug3() {
        return tug3;
    }

    public void setTug3(int tug3) {
        this.tug3 = tug3;
    }

    public int getTug2() {
        return tug2;
    }

    public void setTug2(int tug2) {
        this.tug2 = tug2;
    }

    public int getTu12() {
        return tu12;
    }

    public void setTu12(int tu12) {
        this.tu12 = tu12;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zte != null ? zte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeslotTransform)) {
            return false;
        }
        TimeslotTransform other = (TimeslotTransform) object;
        if ((this.zte == null && other.zte != null) || (this.zte != null && !this.zte.equals(other.zte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TimeslotTransform[ zte=" + zte + " ]";
    }
    
}
