/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THIAGO
 */
@Entity
@Table(name = "moto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moto.findAll", query = "SELECT m FROM Moto m"),
    @NamedQuery(name = "Moto.findByIdMoto", query = "SELECT m FROM Moto m WHERE m.idMoto = :idMoto"),
    @NamedQuery(name = "Moto.findByMarcaMoto", query = "SELECT m FROM Moto m WHERE m.marcaMoto = :marcaMoto"),
    @NamedQuery(name = "Moto.findByModeloMoto", query = "SELECT m FROM Moto m WHERE m.modeloMoto = :modeloMoto"),
    @NamedQuery(name = "Moto.findByAnoMoto", query = "SELECT m FROM Moto m WHERE m.anoMoto = :anoMoto"),
    @NamedQuery(name = "Moto.findByPlacaMoto", query = "SELECT m FROM Moto m WHERE m.placaMoto = :placaMoto"),
    @NamedQuery(name = "Moto.findByStatus", query = "SELECT m FROM Moto m WHERE m.status = :status")})
public class Moto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moto")
    private Integer idMoto;
    @Size(max = 50)
    @Column(name = "marca_moto")
    private String marcaMoto;
    @Size(max = 50)
    @Column(name = "modelo_moto")
    private String modeloMoto;
    @Size(max = 10)
    @Column(name = "ano_moto")
    private String anoMoto;
    @Size(max = 8)
    @Column(name = "placa_moto")
    private String placaMoto;
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    @JoinTable(name = "pessoa_moto", joinColumns = {
        @JoinColumn(name = "id_moto_moto", referencedColumnName = "id_moto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_pessoa_pessoa", referencedColumnName = "id_pessoa")})
    @ManyToMany
    private List<Pessoa> pessoaList;

    public Moto() {
    }

    public Moto(Integer idMoto) {
        this.idMoto = idMoto;
    }

    public Integer getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Integer idMoto) {
        this.idMoto = idMoto;
    }

    public String getMarcaMoto() {
        return marcaMoto;
    }

    public void setMarcaMoto(String marcaMoto) {
        this.marcaMoto = marcaMoto;
    }

    public String getModeloMoto() {
        return modeloMoto;
    }

    public void setModeloMoto(String modeloMoto) {
        this.modeloMoto = modeloMoto;
    }

    public String getAnoMoto() {
        return anoMoto;
    }

    public void setAnoMoto(String anoMoto) {
        this.anoMoto = anoMoto;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoto != null ? idMoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moto)) {
            return false;
        }
        Moto other = (Moto) object;
        if ((this.idMoto == null && other.idMoto != null) || (this.idMoto != null && !this.idMoto.equals(other.idMoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Moto[ idMoto=" + idMoto + " ]";
    }
    
}
