/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "otn_ne_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtnNeInfo.findAll", query = "SELECT o FROM OtnNeInfo o")
    , @NamedQuery(name = "OtnNeInfo.findByNeId", query = "SELECT o FROM OtnNeInfo o WHERE o.neId = :neId")
    , @NamedQuery(name = "OtnNeInfo.findByNeName", query = "SELECT o FROM OtnNeInfo o WHERE o.neName = :neName")
    , @NamedQuery(name = "OtnNeInfo.findByNeType", query = "SELECT o FROM OtnNeInfo o WHERE o.neType = :neType")
    , @NamedQuery(name = "OtnNeInfo.findByNeIp", query = "SELECT o FROM OtnNeInfo o WHERE o.neIp = :neIp")
    , @NamedQuery(name = "OtnNeInfo.findByNeVer", query = "SELECT o FROM OtnNeInfo o WHERE o.neVer = :neVer")
    , @NamedQuery(name = "OtnNeInfo.findByCreateTime", query = "SELECT o FROM OtnNeInfo o WHERE o.createTime = :createTime")
    , @NamedQuery(name = "OtnNeInfo.findByRemarks", query = "SELECT o FROM OtnNeInfo o WHERE o.remarks = :remarks")})
public class OtnNeInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ne_id")
    private String neId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ne_name")
    private String neName;
    @Size(max = 45)
    @Column(name = "ne_type")
    private String neType;
    @Size(max = 45)
    @Column(name = "ne_ip")
    private String neIp;
    @Size(max = 45)
    @Column(name = "ne_ver")
    private String neVer;
    @Basic(optional = false)
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;

    public OtnNeInfo() {
    }

    public OtnNeInfo(String neId) {
        this.neId = neId;
    }

    public OtnNeInfo(String neId, String neName, Date createTime) {
        this.neId = neId;
        this.neName = neName;
        this.createTime = createTime;
    }

    public String getNeId() {
        return neId;
    }

    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public String getNeType() {
        return neType;
    }

    public void setNeType(String neType) {
        this.neType = neType;
    }

    public String getNeIp() {
        return neIp;
    }

    public void setNeIp(String neIp) {
        this.neIp = neIp;
    }

    public String getNeVer() {
        return neVer;
    }

    public void setNeVer(String neVer) {
        this.neVer = neVer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public OtnNeInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtnNeInfo)) {
            return false;
        }
        OtnNeInfo other = (OtnNeInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.OtnNeInfo[ id=" + id + " ]";
    }
    
}
