/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THIAGO
 */
@Entity
@Table(name = "movimento_caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentoCaixa.findAll", query = "SELECT m FROM MovimentoCaixa m"),
    @NamedQuery(name = "MovimentoCaixa.findByIdMovCaixa", query = "SELECT m FROM MovimentoCaixa m WHERE m.idMovCaixa = :idMovCaixa"),
    @NamedQuery(name = "MovimentoCaixa.findByDataMovCaixa", query = "SELECT m FROM MovimentoCaixa m WHERE m.dataMovCaixa = :dataMovCaixa"),
    @NamedQuery(name = "MovimentoCaixa.findByValorMovCaixa", query = "SELECT m FROM MovimentoCaixa m WHERE m.valorMovCaixa = :valorMovCaixa"),
    @NamedQuery(name = "MovimentoCaixa.findByObsMovCaixa", query = "SELECT m FROM MovimentoCaixa m WHERE m.obsMovCaixa = :obsMovCaixa")})
public class MovimentoCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mov_caixa")
    private Integer idMovCaixa;
    @Size(max = 10)
    @Column(name = "data_mov_caixa")
    private String dataMovCaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_mov_caixa")
    private Double valorMovCaixa;
    @Size(max = 255)
    @Column(name = "obs_mov_caixa")
    private String obsMovCaixa;
    @JoinColumn(name = "id_tipo_mov", referencedColumnName = "id_tipo_mov")
    @ManyToOne(optional = false)
    private TipoMovimento idTipoMov;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;
    @JoinColumn(name = "id_emp", referencedColumnName = "id_emp")
    @ManyToOne(optional = false)
    private Empresa idEmp;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(Integer idMovCaixa) {
        this.idMovCaixa = idMovCaixa;
    }

    public Integer getIdMovCaixa() {
        return idMovCaixa;
    }

    public void setIdMovCaixa(Integer idMovCaixa) {
        this.idMovCaixa = idMovCaixa;
    }

    public String getDataMovCaixa() {
        return dataMovCaixa;
    }

    public void setDataMovCaixa(String dataMovCaixa) {
        this.dataMovCaixa = dataMovCaixa;
    }

    public Double getValorMovCaixa() {
        return valorMovCaixa;
    }

    public void setValorMovCaixa(Double valorMovCaixa) {
        this.valorMovCaixa = valorMovCaixa;
    }

    public String getObsMovCaixa() {
        return obsMovCaixa;
    }

    public void setObsMovCaixa(String obsMovCaixa) {
        this.obsMovCaixa = obsMovCaixa;
    }

    public TipoMovimento getIdTipoMov() {
        return idTipoMov;
    }

    public void setIdTipoMov(TipoMovimento idTipoMov) {
        this.idTipoMov = idTipoMov;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Empresa getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Empresa idEmp) {
        this.idEmp = idEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovCaixa != null ? idMovCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentoCaixa)) {
            return false;
        }
        MovimentoCaixa other = (MovimentoCaixa) object;
        if ((this.idMovCaixa == null && other.idMovCaixa != null) || (this.idMovCaixa != null && !this.idMovCaixa.equals(other.idMovCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MovimentoCaixa[ idMovCaixa=" + idMovCaixa + " ]";
    }
    
}
