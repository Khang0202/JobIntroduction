/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findById", query = "SELECT s FROM Skill s WHERE s.skillPK.id = :id"),
    @NamedQuery(name = "Skill.findByUserid", query = "SELECT s FROM Skill s WHERE s.skillPK.userid = :userid"),
    @NamedQuery(name = "Skill.findBySkill", query = "SELECT s FROM Skill s WHERE s.skill = :skill")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkillPK skillPK;
    @Size(max = 100)
    @Column(name = "skill")
    private String skill;
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Skill() {
    }

    public Skill(SkillPK skillPK) {
        this.skillPK = skillPK;
    }

    public Skill(int id, int userid) {
        this.skillPK = new SkillPK(id, userid);
    }

    public SkillPK getSkillPK() {
        return skillPK;
    }

    public void setSkillPK(SkillPK skillPK) {
        this.skillPK = skillPK;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillPK != null ? skillPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillPK == null && other.skillPK != null) || (this.skillPK != null && !this.skillPK.equals(other.skillPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oujava.pojo.Skill[ skillPK=" + skillPK + " ]";
    }
    
}
