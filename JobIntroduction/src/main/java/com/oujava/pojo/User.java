/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.pojo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByImage", query = "SELECT u FROM User u WHERE u.image = :image"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "User.findByBirth", query = "SELECT u FROM User u WHERE u.birth = :birth"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByExperience", query = "SELECT u FROM User u WHERE u.experience = :experience"),
    @NamedQuery(name = "User.findByFilecv", query = "SELECT u FROM User u WHERE u.filecv = :filecv"),
    @NamedQuery(name = "User.findByCurentposition", query = "SELECT u FROM User u WHERE u.curentposition = :curentposition"),
    @NamedQuery(name = "User.findByEducation", query = "SELECT u FROM User u WHERE u.education = :education"),
    @NamedQuery(name = "User.findByCountry", query = "SELECT u FROM User u WHERE u.country = :country"),
    @NamedQuery(name = "User.findByUrlinfo", query = "SELECT u FROM User u WHERE u.urlinfo = :urlinfo")})
public class User implements Serializable {

    /**
     * @return the birthform
     */
    public String getBirthform() {
        return birthform;
    }

    /**
     * @param birthform the birthform to set
     */
    public void setBirthform(String birthform) {
        this.birthform = birthform;
    }

    /**
     * @return the file
     */
    

    /**
     * @return the fileImage
     */

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "experience")
    private Integer experience;
    @Size(max = 255)
    @Column(name = "filecv")
    private String filecv;
    @Size(max = 100)
    @Column(name = "curentposition")
    private String curentposition;
    @Size(max = 100)
    @Column(name = "education")
    private String education;
    @Size(max = 100)
    @Column(name = "country")
    private String country;
    @Size(max = 100)
    @Column(name = "urlinfo")
    private String urlinfo;
    @OneToMany(mappedBy = "candidateId")
    private Set<Apply> applySet;
    @OneToMany(mappedBy = "employerId")
    private Set<Apply> applySet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Set<Skill> skillSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerId")
    private Set<Rating> ratingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId")
    private Set<Rating> ratingSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerId")
    private Set<Job> jobSet;
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    @ManyToOne
    private Faculty facultyId;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Role roleId;
    
    @Transient
    private MultipartFile file;
    @Transient
    private String birthform;
    
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String lastName, String image, String email, String phone, String sex, Date birth, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birth = birth;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getFilecv() {
        return filecv;
    }

    public void setFilecv(String filecv) {
        this.filecv = filecv;
    }

    public String getCurentposition() {
        return curentposition;
    }

    public void setCurentposition(String curentposition) {
        this.curentposition = curentposition;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUrlinfo() {
        return urlinfo;
    }

    public void setUrlinfo(String urlinfo) {
        this.urlinfo = urlinfo;
    }

    @XmlTransient
    public Set<Apply> getApplySet() {
        return applySet;
    }

    public void setApplySet(Set<Apply> applySet) {
        this.applySet = applySet;
    }

    @XmlTransient
    public Set<Apply> getApplySet1() {
        return applySet1;
    }

    public void setApplySet1(Set<Apply> applySet1) {
        this.applySet1 = applySet1;
    }

    @XmlTransient
    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Rating> getRatingSet1() {
        return ratingSet1;
    }

    public void setRatingSet1(Set<Rating> ratingSet1) {
        this.ratingSet1 = ratingSet1;
    }

    @XmlTransient
    public Set<Job> getJobSet() {
        return jobSet;
    }

    public void setJobSet(Set<Job> jobSet) {
        this.jobSet = jobSet;
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oujava.pojo.User[ id=" + id + " ]";
    }
    
}
