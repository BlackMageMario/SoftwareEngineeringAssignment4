/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldatabase;

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
 * @author Eamonn Hannon
 */
@Entity
@Table(name = "videogames")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videogames.findAll", query = "SELECT v FROM Videogames v")
    , @NamedQuery(name = "Videogames.findById", query = "SELECT v FROM Videogames v WHERE v.id = :id")
    , @NamedQuery(name = "Videogames.findByProdName", query = "SELECT v FROM Videogames v WHERE v.prodName = :prodName")
    , @NamedQuery(name = "Videogames.findByReleDate", query = "SELECT v FROM Videogames v WHERE v.releDate = :releDate")
    , @NamedQuery(name = "Videogames.findByRrPrice", query = "SELECT v FROM Videogames v WHERE v.rrPrice = :rrPrice")
    , @NamedQuery(name = "Videogames.findByPlatform", query = "SELECT v FROM Videogames v WHERE v.platform = :platform")})
public class Videogames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prodName")
    private String prodName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pubName")
    private String pubName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "devName")
    private String devName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "releDate")
    @Temporal(TemporalType.DATE)
    private Date releDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rrPrice")
    private int rrPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "platform")
    private String platform;

    public Videogames() {
    }

    public Videogames(Integer id) {
        this.id = id;
    }

    public Videogames(Integer id, String prodName, String pubName, String devName, Date releDate, int rrPrice, String platform) {
        this.id = id;
        this.prodName = prodName;
        this.pubName = pubName;
        this.devName = devName;
        this.releDate = releDate;
        this.rrPrice = rrPrice;
        this.platform = platform;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public Date getReleDate() {
        return releDate;
    }

    public void setReleDate(Date releDate) {
        this.releDate = releDate;
    }

    public int getRrPrice() {
        return rrPrice;
    }

    public void setRrPrice(int rrPrice) {
        this.rrPrice = rrPrice;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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
        if (!(object instanceof Videogames)) {
            return false;
        }
        Videogames other = (Videogames) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mysqldatabase.Videogames[ id=" + id + " ]";
    }
    
}
