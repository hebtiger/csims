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
@Table(name = "spare_part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SparePart.findAll", query = "SELECT s FROM SparePart s")
    , @NamedQuery(name = "SparePart.findById", query = "SELECT s FROM SparePart s WHERE s.id = :id")
    , @NamedQuery(name = "SparePart.findByPartName", query = "SELECT s FROM SparePart s WHERE s.partName = :partName")
    , @NamedQuery(name = "SparePart.findByPartModel", query = "SELECT s FROM SparePart s WHERE s.partModel = :partModel")
    , @NamedQuery(name = "SparePart.findByPartNumber", query = "SELECT s FROM SparePart s WHERE s.partNumber = :partNumber")
    , @NamedQuery(name = "SparePart.findByMeasurement", query = "SELECT s FROM SparePart s WHERE s.measurement = :measurement")
    , @NamedQuery(name = "SparePart.findByDepositPlace", query = "SELECT s FROM SparePart s WHERE s.depositPlace = :depositPlace")
    , @NamedQuery(name = "SparePart.findByRemarks", query = "SELECT s FROM SparePart s WHERE s.remarks = :remarks")
    , @NamedQuery(name = "SparePart.findByUpdateTime", query = "SELECT s FROM SparePart s WHERE s.updateTime = :updateTime")
    , @NamedQuery(name = "SparePart.findByUnitPrice", query = "SELECT s FROM SparePart s WHERE s.unitPrice = :unitPrice")
    , @NamedQuery(name = "SparePart.findByTotalPrice", query = "SELECT s FROM SparePart s WHERE s.totalPrice = :totalPrice")})
public class SparePart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_name")
    private String partName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_model")
    private String partModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_number")
    private String partNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "measurement")
    private String measurement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "deposit_place")
    private String depositPlace;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;
    @Basic(optional = false)
   
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "unit_price")
    private Integer unitPrice;
    @Column(name = "total_price")
    private Integer totalPrice;

    public SparePart() {
    }

    public SparePart(Integer id) {
        this.id = id;
    }

    public SparePart(Integer id, String partName, String partModel, String partNumber, String measurement, String depositPlace, Date updateTime) {
        this.id = id;
        this.partName = partName;
        this.partModel = partModel;
        this.partNumber = partNumber;
        this.measurement = measurement;
        this.depositPlace = depositPlace;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartModel() {
        return partModel;
    }

    public void setPartModel(String partModel) {
        this.partModel = partModel;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getDepositPlace() {
        return depositPlace;
    }

    public void setDepositPlace(String depositPlace) {
        this.depositPlace = depositPlace;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
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
        if (!(object instanceof SparePart)) {
            return false;
        }
        SparePart other = (SparePart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SparePart[ id=" + id + " ]";
    }
    
}
