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
@Table(name = "otn_service_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtnServiceInfo.findAll", query = "SELECT o FROM OtnServiceInfo o")
    , @NamedQuery(name = "OtnServiceInfo.findById", query = "SELECT o FROM OtnServiceInfo o WHERE o.id = :id")
    , @NamedQuery(name = "OtnServiceInfo.findByRateLevel", query = "SELECT o FROM OtnServiceInfo o WHERE o.rateLevel = :rateLevel")
    , @NamedQuery(name = "OtnServiceInfo.findBySourceSite", query = "SELECT o FROM OtnServiceInfo o WHERE o.sourceSite = :sourceSite")
    , @NamedQuery(name = "OtnServiceInfo.findBySourceServicePort", query = "SELECT o FROM OtnServiceInfo o WHERE o.sourceServicePort = :sourceServicePort")
    , @NamedQuery(name = "OtnServiceInfo.findByLineProperty", query = "SELECT o FROM OtnServiceInfo o WHERE o.lineProperty = :lineProperty")
    , @NamedQuery(name = "OtnServiceInfo.findBySourcePort", query = "SELECT o FROM OtnServiceInfo o WHERE o.sourcePort = :sourcePort")
    , @NamedQuery(name = "OtnServiceInfo.findBySourceDirection", query = "SELECT o FROM OtnServiceInfo o WHERE o.sourceDirection = :sourceDirection")
    , @NamedQuery(name = "OtnServiceInfo.findByFrequency", query = "SELECT o FROM OtnServiceInfo o WHERE o.frequency = :frequency")
    , @NamedQuery(name = "OtnServiceInfo.findByTerminalDirection", query = "SELECT o FROM OtnServiceInfo o WHERE o.terminalDirection = :terminalDirection")
    , @NamedQuery(name = "OtnServiceInfo.findByTerminalPort", query = "SELECT o FROM OtnServiceInfo o WHERE o.terminalPort = :terminalPort")
    , @NamedQuery(name = "OtnServiceInfo.findByTerminalServicePort", query = "SELECT o FROM OtnServiceInfo o WHERE o.terminalServicePort = :terminalServicePort")
    , @NamedQuery(name = "OtnServiceInfo.findByTerminalSite", query = "SELECT o FROM OtnServiceInfo o WHERE o.terminalSite = :terminalSite")
    , @NamedQuery(name = "OtnServiceInfo.findByUseState", query = "SELECT o FROM OtnServiceInfo o WHERE o.useState = :useState")
    , @NamedQuery(name = "OtnServiceInfo.findByRemarks", query = "SELECT o FROM OtnServiceInfo o WHERE o.remarks = :remarks")})
public class OtnServiceInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rate_level")
    private String rateLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source_site")
    private String sourceSite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source_service_port")
    private String sourceServicePort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "line_property")
    private String lineProperty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source_port")
    private String sourcePort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source_direction")
    private String sourceDirection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "frequency")
    private String frequency;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_direction")
    private String terminalDirection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_port")
    private String terminalPort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_service_port")
    private String terminalServicePort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terminal_site")
    private String terminalSite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "use_state")
    private String useState;
    @Size(max = 45)
    @Column(name = "remarks")
    private String remarks;

    public OtnServiceInfo() {
    }

    public OtnServiceInfo(Integer id) {
        this.id = id;
    }

    public OtnServiceInfo(Integer id, String rateLevel, String sourceSite, String sourceServicePort, String lineProperty, String sourcePort, String sourceDirection, String frequency, String terminalDirection, String terminalPort, String terminalServicePort, String terminalSite, String useState) {
        this.id = id;
        this.rateLevel = rateLevel;
        this.sourceSite = sourceSite;
        this.sourceServicePort = sourceServicePort;
        this.lineProperty = lineProperty;
        this.sourcePort = sourcePort;
        this.sourceDirection = sourceDirection;
        this.frequency = frequency;
        this.terminalDirection = terminalDirection;
        this.terminalPort = terminalPort;
        this.terminalServicePort = terminalServicePort;
        this.terminalSite = terminalSite;
        this.useState = useState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRateLevel() {
        return rateLevel;
    }

    public void setRateLevel(String rateLevel) {
        this.rateLevel = rateLevel;
    }

    public String getSourceSite() {
        return sourceSite;
    }

    public void setSourceSite(String sourceSite) {
        this.sourceSite = sourceSite;
    }

    public String getSourceServicePort() {
        return sourceServicePort;
    }

    public void setSourceServicePort(String sourceServicePort) {
        this.sourceServicePort = sourceServicePort;
    }

    public String getLineProperty() {
        return lineProperty;
    }

    public void setLineProperty(String lineProperty) {
        this.lineProperty = lineProperty;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getSourceDirection() {
        return sourceDirection;
    }

    public void setSourceDirection(String sourceDirection) {
        this.sourceDirection = sourceDirection;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTerminalDirection() {
        return terminalDirection;
    }

    public void setTerminalDirection(String terminalDirection) {
        this.terminalDirection = terminalDirection;
    }

    public String getTerminalPort() {
        return terminalPort;
    }

    public void setTerminalPort(String terminalPort) {
        this.terminalPort = terminalPort;
    }

    public String getTerminalServicePort() {
        return terminalServicePort;
    }

    public void setTerminalServicePort(String terminalServicePort) {
        this.terminalServicePort = terminalServicePort;
    }

    public String getTerminalSite() {
        return terminalSite;
    }

    public void setTerminalSite(String terminalSite) {
        this.terminalSite = terminalSite;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
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
        if (!(object instanceof OtnServiceInfo)) {
            return false;
        }
        OtnServiceInfo other = (OtnServiceInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.OtnServiceInfo[ id=" + id + " ]";
    }
    
}
