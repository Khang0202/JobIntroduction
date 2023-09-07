/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.countAll", query = "SELECT count(*) FROM Job"),
    @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id"),
    @NamedQuery(name = "Job.findByName", query = "SELECT j FROM Job j WHERE j.name = :name"),
    @NamedQuery(name = "Job.findBySalary", query = "SELECT j FROM Job j WHERE j.salary = :salary"),
    @NamedQuery(name = "Job.findByCompany", query = "SELECT j FROM Job j WHERE j.company = :company"),
    @NamedQuery(name = "Job.findByAddress", query = "SELECT j FROM Job j WHERE j.address = :address"),
    @NamedQuery(name = "Job.findByPhone", query = "SELECT j FROM Job j WHERE j.phone = :phone"),
    @NamedQuery(name = "Job.findByEmailcompany", query = "SELECT j FROM Job j WHERE j.emailcompany = :emailcompany"),
    @NamedQuery(name = "Job.findByOtherinfomation", query = "SELECT j FROM Job j WHERE j.otherinfomation = :otherinfomation"),
    @NamedQuery(name = "Job.findByDatePosted", query = "SELECT j FROM Job j WHERE j.datePosted = :datePosted")})
public class Job implements Serializable {

    /**
     * @return the employmentType
     */
    public String getEmploymentType() {
        return employmentType;
    }

    /**
     * @param employmentType the employmentType to set
     */
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    /**
     * @return the posterName
     */
    public String getPosterName() {
        return posterName;
    }

    /**
     * @param posterName the posterName to set
     */
    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailcompany")
    private String emailcompany;
    @Size(max = 255)
    @Column(name = "otherinfomation")
    private String otherinfomation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_posted")
    @Temporal(TemporalType.DATE)
    private Date datePosted;
    @JoinColumn(name = "employment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private EmploymentType employmentTypeId;
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User employerId;

    @Transient
    private String posterName;
    @Transient
    private String employmentType;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Job(Integer id, String firstName, String name, String employment, int salary, String description, String company, String address, String phone, String emailcompany, String otherinfomation, Date datePosted) {
        this.id = id;
        this.posterName = firstName;
        this.name = name;
        this.employmentType = employment;
        this.salary = salary;
        this.description = description;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.emailcompany = emailcompany;
        this.otherinfomation = otherinfomation;
        this.datePosted = datePosted;
    }

    public Job(Integer id, String name, int salary, String company, String address, String phone, String emailcompany, Date datePosted) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.emailcompany = emailcompany;
        this.datePosted = datePosted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailcompany() {
        return emailcompany;
    }

    public void setEmailcompany(String emailcompany) {
        this.emailcompany = emailcompany;
    }

    public String getOtherinfomation() {
        return otherinfomation;
    }

    public void setOtherinfomation(String otherinfomation) {
        this.otherinfomation = otherinfomation;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public EmploymentType getEmploymentTypeId() {
        return employmentTypeId;
    }

    public void setEmploymentTypeId(EmploymentType employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oujava.pojo.Job[ id=" + id + " ]";
    }

}
