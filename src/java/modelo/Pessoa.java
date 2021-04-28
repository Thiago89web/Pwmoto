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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.findByNomePessoa", query = "SELECT p FROM Pessoa p WHERE p.nomePessoa = :nomePessoa"),
    @NamedQuery(name = "Pessoa.findByCpfPessoa", query = "SELECT p FROM Pessoa p WHERE p.cpfPessoa = :cpfPessoa"),
    @NamedQuery(name = "Pessoa.findByRgPessoa", query = "SELECT p FROM Pessoa p WHERE p.rgPessoa = :rgPessoa"),
    @NamedQuery(name = "Pessoa.findByEnderecoPessoa", query = "SELECT p FROM Pessoa p WHERE p.enderecoPessoa = :enderecoPessoa"),
    @NamedQuery(name = "Pessoa.findByTelefonePessoa", query = "SELECT p FROM Pessoa p WHERE p.telefonePessoa = :telefonePessoa"),
    @NamedQuery(name = "Pessoa.findByEmailPessoa", query = "SELECT p FROM Pessoa p WHERE p.emailPessoa = :emailPessoa"),
    @NamedQuery(name = "Pessoa.findByDataNascPessoa", query = "SELECT p FROM Pessoa p WHERE p.dataNascPessoa = :dataNascPessoa"),
    @NamedQuery(name = "Pessoa.findByNumCnhPessoa", query = "SELECT p FROM Pessoa p WHERE p.numCnhPessoa = :numCnhPessoa"),
    @NamedQuery(name = "Pessoa.findByDataValCnhPessoa", query = "SELECT p FROM Pessoa p WHERE p.dataValCnhPessoa = :dataValCnhPessoa"),
    @NamedQuery(name = "Pessoa.findByIdMoto", query = "SELECT p FROM Pessoa p WHERE p.idMoto = :idMoto")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Size(max = 255)
    @Column(name = "nome_pessoa")
    private String nomePessoa;
    @Size(max = 15)
    @Column(name = "cpf_pessoa")
    private String cpfPessoa;
    @Size(max = 15)
    @Column(name = "rg_pessoa")
    private String rgPessoa;
    @Size(max = 120)
    @Column(name = "endereco_pessoa")
    private String enderecoPessoa;
    @Size(max = 20)
    @Column(name = "telefone_pessoa")
    private String telefonePessoa;
    @Size(max = 120)
    @Column(name = "email_pessoa")
    private String emailPessoa;
    @Size(max = 10)
    @Column(name = "data_nasc_pessoa")
    private String dataNascPessoa;
    @Size(max = 12)
    @Column(name = "num_cnh_pessoa")
    private String numCnhPessoa;
    @Size(max = 10)
    @Column(name = "data_val_cnh_pessoa")
    private String dataValCnhPessoa;
    @Basic(optional = false)
    @Column(name = "id_moto")
    private int idMoto;
    @ManyToMany(mappedBy = "pessoaList")
    private List<Moto> motoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<TipoPessoa> tipoPessoaList;
    @JoinColumn(name = "id_emp", referencedColumnName = "id_emp")
    @ManyToOne(optional = false)
    private Empresa idEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<MovimentoCaixa> movimentoCaixaList;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(Integer idPessoa, int idMoto) {
        this.idPessoa = idPessoa;
        this.idMoto = idMoto;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getDataNascPessoa() {
        return dataNascPessoa;
    }

    public void setDataNascPessoa(String dataNascPessoa) {
        this.dataNascPessoa = dataNascPessoa;
    }

    public String getNumCnhPessoa() {
        return numCnhPessoa;
    }

    public void setNumCnhPessoa(String numCnhPessoa) {
        this.numCnhPessoa = numCnhPessoa;
    }

    public String getDataValCnhPessoa() {
        return dataValCnhPessoa;
    }

    public void setDataValCnhPessoa(String dataValCnhPessoa) {
        this.dataValCnhPessoa = dataValCnhPessoa;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    @XmlTransient
    public List<Moto> getMotoList() {
        return motoList;
    }

    public void setMotoList(List<Moto> motoList) {
        this.motoList = motoList;
    }

    @XmlTransient
    public List<TipoPessoa> getTipoPessoaList() {
        return tipoPessoaList;
    }

    public void setTipoPessoaList(List<TipoPessoa> tipoPessoaList) {
        this.tipoPessoaList = tipoPessoaList;
    }

    public Empresa getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Empresa idEmp) {
        this.idEmp = idEmp;
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
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
