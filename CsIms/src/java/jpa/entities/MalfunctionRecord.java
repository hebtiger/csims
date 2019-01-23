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
import javax.persistence.Lob;
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
@Table(name = "malfunction_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MalfunctionRecord.findAll", query = "SELECT m FROM MalfunctionRecord m")
    , @NamedQuery(name = "MalfunctionRecord.findById", query = "SELECT m FROM MalfunctionRecord m WHERE m.id = :id")
    , @NamedQuery(name = "MalfunctionRecord.findByNetType", query = "SELECT m FROM MalfunctionRecord m WHERE m.netType = :netType")
    , @NamedQuery(name = "MalfunctionRecord.findByOccurrenceTime", query = "SELECT m FROM MalfunctionRecord m WHERE m.occurrenceTime = :occurrenceTime")
    , @NamedQuery(name = "MalfunctionRecord.findByFaultLocation", query = "SELECT m FROM MalfunctionRecord m WHERE m.faultLocation = :faultLocation")
    , @NamedQuery(name = "MalfunctionRecord.findByRecoveryTime", query = "SELECT m FROM MalfunctionRecord m WHERE m.recoveryTime = :recoveryTime")
    , @NamedQuery(name = "MalfunctionRecord.findByStaff", query = "SELECT m FROM MalfunctionRecord m WHERE m.staff = :staff")
    , @NamedQuery(name = "MalfunctionRecord.findByCreateTime", query = "SELECT m FROM MalfunctionRecord m WHERE m.createTime = :createTime")})
public class MalfunctionRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "net_type")
    private String netType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "occurrence_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fault_location")
    private String faultLocation;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "malfunction_detail")
    private String malfunctionDetail;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "influence_sphere")
    private String influenceSphere;
    @Lob
    @Size(max = 65535)
    @Column(name = "malfunction_analysis")
    private String malfunctionAnalysis;
    @Lob
    @Size(max = 65535)
    @Column(name = "processing")
    private String processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recovery_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recoveryTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "staff")
    private String staff;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public MalfunctionRecord() {
    }

    public MalfunctionRecord(Integer id) {
        this.id = id;
    }

    public MalfunctionRecord(Integer id, String netType, Date occurrenceTime, String faultLocation, String malfunctionDetail, String influenceSphere, Date recoveryTime, String staff, Date createTime) {
        this.id = id;
        this.netType = netType;
        this.occurrenceTime = occurrenceTime;
        this.faultLocation = faultLocation;
        this.malfunctionDetail = malfunctionDetail;
        this.influenceSphere = influenceSphere;
        this.recoveryTime = recoveryTime;
        this.staff = staff;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getFaultLocation() {
        return faultLocation;
    }

    public void setFaultLocation(String faultLocation) {
        this.faultLocation = faultLocation;
    }

    public String getMalfunctionDetail() {
        return malfunctionDetail;
    }

    public void setMalfunctionDetail(String malfunctionDetail) {
        this.malfunctionDetail = malfunctionDetail;
    }

    public String getInfluenceSphere() {
        return influenceSphere;
    }

    public void setInfluenceSphere(String influenceSphere) {
        this.influenceSphere = influenceSphere;
    }

    public String getMalfunctionAnalysis() {
        return malfunctionAnalysis;
    }

    public void setMalfunctionAnalysis(String malfunctionAnalysis) {
        this.malfunctionAnalysis = malfunctionAnalysis;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public Date getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(Date recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        if (!(object instanceof MalfunctionRecord)) {
            return false;
        }
        MalfunctionRecord other = (MalfunctionRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MalfunctionRecord[ id=" + id + " ]";
    }
    
}
