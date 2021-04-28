/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THIAGO
 */
@Entity
@Table(name = "tipo_movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimento.findAll", query = "SELECT t FROM TipoMovimento t"),
    @NamedQuery(name = "TipoMovimento.findByIdTipoMov", query = "SELECT t FROM TipoMovimento t WHERE t.idTipoMov = :idTipoMov"),
    @NamedQuery(name = "TipoMovimento.findByNomeTipoMov", query = "SELECT t FROM TipoMovimento t WHERE t.nomeTipoMov = :nomeTipoMov"),
    @NamedQuery(name = "TipoMovimento.findByTipoMov", query = "SELECT t FROM TipoMovimento t WHERE t.tipoMov = :tipoMov")})
public class TipoMovimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_mov")
    private Integer idTipoMov;
    @Size(max = 255)
    @Column(name = "nome_tipo_mov")
    private String nomeTipoMov;
    @Size(max = 7)
    @Column(name = "tipo_mov")
    private String tipoMov;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMov")
    private List<MovimentoCaixa> movimentoCaixaList;

    public TipoMovimento() {
    }

    public TipoMovimento(Integer idTipoMov) {
        this.idTipoMov = idTipoMov;
    }

    public Integer getIdTipoMov() {
        return idTipoMov;
    }

    public void setIdTipoMov(Integer idTipoMov) {
        this.idTipoMov = idTipoMov;
    }

    public String getNomeTipoMov() {
        return nomeTipoMov;
    }

    public void setNomeTipoMov(String nomeTipoMov) {
        this.nomeTipoMov = nomeTipoMov;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    @XmlTransient
    public List<MovimentoCaixa> getMovimentoCaixaList() {
        return movimentoCaixaList;
    }

    public void setMovimentoCaixaList(List<MovimentoCaixa> movimentoCaixaList) {
        this.movimentoCaixaList = movimentoCaixaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMov != null ? idTipoMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimento)) {
            return false;
        }
        TipoMovimento other = (TipoMovimento) object;
        if ((this.idTipoMov == null && other.idTipoMov != null) || (this.idTipoMov != null && !this.idTipoMov.equals(other.idTipoMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoMovimento[ idTipoMov=" + idTipoMov + " ]";
    }
    
}
