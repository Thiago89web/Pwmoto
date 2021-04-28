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
@Table(name = "tipo_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPessoa.findAll", query = "SELECT t FROM TipoPessoa t"),
    @NamedQuery(name = "TipoPessoa.findByIdTipoPessoa", query = "SELECT t FROM TipoPessoa t WHERE t.idTipoPessoa = :idTipoPessoa"),
    @NamedQuery(name = "TipoPessoa.findByNomeTipoPessoa", query = "SELECT t FROM TipoPessoa t WHERE t.nomeTipoPessoa = :nomeTipoPessoa"),
    @NamedQuery(name = "TipoPessoa.findByPeriodoInicio", query = "SELECT t FROM TipoPessoa t WHERE t.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "TipoPessoa.findByPeriodoFim", query = "SELECT t FROM TipoPessoa t WHERE t.periodoFim = :periodoFim")})
public class TipoPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pessoa")
    private Integer idTipoPessoa;
    @Size(max = 100)
    @Column(name = "nome_tipo_pessoa")
    private String nomeTipoPessoa;
    @Size(max = 10)
    @Column(name = "periodo_inicio")
    private String periodoInicio;
    @Size(max = 10)
    @Column(name = "periodo_fim")
    private String periodoFim;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public TipoPessoa() {
    }

    public TipoPessoa(Integer idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public Integer getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(Integer idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public String getNomeTipoPessoa() {
        return nomeTipoPessoa;
    }

    public void setNomeTipoPessoa(String nomeTipoPessoa) {
        this.nomeTipoPessoa = nomeTipoPessoa;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public String getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(String periodoFim) {
        this.periodoFim = periodoFim;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPessoa != null ? idTipoPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPessoa)) {
            return false;
        }
        TipoPessoa other = (TipoPessoa) object;
        if ((this.idTipoPessoa == null && other.idTipoPessoa != null) || (this.idTipoPessoa != null && !this.idTipoPessoa.equals(other.idTipoPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoPessoa[ idTipoPessoa=" + idTipoPessoa + " ]";
    }
    
}
