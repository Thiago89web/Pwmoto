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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmp", query = "SELECT e FROM Empresa e WHERE e.idEmp = :idEmp"),
    @NamedQuery(name = "Empresa.findByNomeEmp", query = "SELECT e FROM Empresa e WHERE e.nomeEmp = :nomeEmp"),
    @NamedQuery(name = "Empresa.findByCnpjEmp", query = "SELECT e FROM Empresa e WHERE e.cnpjEmp = :cnpjEmp"),
    @NamedQuery(name = "Empresa.findByTelefoneEmp", query = "SELECT e FROM Empresa e WHERE e.telefoneEmp = :telefoneEmp"),
    @NamedQuery(name = "Empresa.findByEnderecoEmp", query = "SELECT e FROM Empresa e WHERE e.enderecoEmp = :enderecoEmp"),
    @NamedQuery(name = "Empresa.findByResponsavelEmp", query = "SELECT e FROM Empresa e WHERE e.responsavelEmp = :responsavelEmp")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emp")
    private Integer idEmp;
    @Size(max = 200)
    @Column(name = "nome_emp")
    private String nomeEmp;
    @Size(max = 30)
    @Column(name = "cnpj_emp")
    private String cnpjEmp;
    @Size(max = 20)
    @Column(name = "telefone_emp")
    private String telefoneEmp;
    @Size(max = 120)
    @Column(name = "endereco_emp")
    private String enderecoEmp;
    @Size(max = 120)
    @Column(name = "responsavel_emp")
    private String responsavelEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmp")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmp")
    private List<MovimentoCaixa> movimentoCaixaList;

    public Empresa() {
    }

    public Empresa(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getNomeEmp() {
        return nomeEmp;
    }

    public void setNomeEmp(String nomeEmp) {
        this.nomeEmp = nomeEmp;
    }

    public String getCnpjEmp() {
        return cnpjEmp;
    }

    public void setCnpjEmp(String cnpjEmp) {
        this.cnpjEmp = cnpjEmp;
    }

    public String getTelefoneEmp() {
        return telefoneEmp;
    }

    public void setTelefoneEmp(String telefoneEmp) {
        this.telefoneEmp = telefoneEmp;
    }

    public String getEnderecoEmp() {
        return enderecoEmp;
    }

    public void setEnderecoEmp(String enderecoEmp) {
        this.enderecoEmp = enderecoEmp;
    }

    public String getResponsavelEmp() {
        return responsavelEmp;
    }

    public void setResponsavelEmp(String responsavelEmp) {
        this.responsavelEmp = responsavelEmp;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idEmp + " " + nomeEmp;
    }
    
}
