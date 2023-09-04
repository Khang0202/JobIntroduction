/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "apply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apply.findAll", query = "SELECT a FROM Apply a"),
    @NamedQuery(name = "Apply.findById", query = "SELECT a FROM Apply a WHERE a.id = :id"),
    @NamedQuery(name = "Apply.findByCreatedDate", query = "SELECT a FROM Apply a WHERE a.createdDate = :createdDate")})
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne
    private User candidateId;
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    @ManyToOne
    private User employerId;

    public Apply() {
    }

    public Apply(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(User candidateId) {
        this.candidateId = candidateId;
    }

    public User getEmployerId() {
        return employerId;
    }

    public void setEmployerId(User employerId) {
        this.employerId = employerId;
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
        if (!(object instanceof Apply)) {
            return false;
        }
        Apply other = (Apply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oujava.pojo.Apply[ id=" + id + " ]";
    }
    
}
