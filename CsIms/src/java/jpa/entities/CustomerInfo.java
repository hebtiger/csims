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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "customer_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerInfo.findAll", query = "SELECT c FROM CustomerInfo c")
    , @NamedQuery(name = "CustomerInfo.findById", query = "SELECT c FROM CustomerInfo c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerInfo.findByCustomerName", query = "SELECT c FROM CustomerInfo c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "CustomerInfo.findByCustomerFullname", query = "SELECT c FROM CustomerInfo c WHERE c.customerFullname = :customerFullname")
    , @NamedQuery(name = "CustomerInfo.findByContactStaff", query = "SELECT c FROM CustomerInfo c WHERE c.contactStaff = :contactStaff")
    , @NamedQuery(name = "CustomerInfo.findByContactNumber", query = "SELECT c FROM CustomerInfo c WHERE c.contactNumber = :contactNumber")
    , @NamedQuery(name = "CustomerInfo.findByAddress", query = "SELECT c FROM CustomerInfo c WHERE c.address = :address")
    , @NamedQuery(name = "CustomerInfo.findByCustomerDistrict", query = "SELECT c FROM CustomerInfo c WHERE c.customerDistrict = :customerDistrict")
    , @NamedQuery(name = "CustomerInfo.findByRemarks", query = "SELECT c FROM CustomerInfo c WHERE c.remarks = :remarks")})
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_fullname")
    private String customerFullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_staff")
    private String contactStaff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_district")
    private String customerDistrict;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;

    public CustomerInfo() {
    }

    public CustomerInfo(Integer id) {
        this.id = id;
    }

    public CustomerInfo(Integer id, String customerName, String customerFullname, String contactStaff, String contactNumber, String address, String customerDistrict) {
        this.id = id;
        this.customerName = customerName;
        this.customerFullname = customerFullname;
        this.contactStaff = contactStaff;
        this.contactNumber = contactNumber;
        this.address = address;
        this.customerDistrict = customerDistrict;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    public String getContactStaff() {
        return contactStaff;
    }

    public void setContactStaff(String contactStaff) {
        this.contactStaff = contactStaff;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerDistrict() {
        return customerDistrict;
    }

    public void setCustomerDistrict(String customerDistrict) {
        this.customerDistrict = customerDistrict;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof CustomerInfo)) {
            return false;
        }
        CustomerInfo other = (CustomerInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CustomerInfo[ id=" + id + " ]";
    }
    
}
