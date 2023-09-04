/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.DTO;

import com.oujava.pojo.User;

/**
 *
 * @author trann
 */
public class RegisterDTO {


    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the experince
     */
    public int getExperince() {
        return experince;
    }

    /**
     * @param experince the experince to set
     */
    public void setExperince(int experince) {
        this.experince = experince;
    }

    /**
     * @return the filecv
     */
    public String getFilecv() {
        return filecv;
    }

    /**
     * @param filecv the filecv to set
     */
    public void setFilecv(String filecv) {
        this.filecv = filecv;
    }

    /**
     * @return the currentposition
     */
    public String getCurrentposition() {
        return currentposition;
    }

    /**
     * @param currentposition the currentposition to set
     */
    public void setCurrentposition(String currentposition) {
        this.currentposition = currentposition;
    }

    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the urlinfo
     */
    public String getUrlinfo() {
        return urlinfo;
    }

    /**
     * @param urlinfo the urlinfo to set
     */
    public void setUrlinfo(String urlinfo) {
        this.urlinfo = urlinfo;
    }
    private String firstname;
    private String lastname;
    private String image;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String address;
    private int experince;
    private String filecv;
    private String currentposition;
    private String education;
    private String country;
    private String urlinfo;

    
    public RegisterDTO(){
    }
    public RegisterDTO(String firstname, String lastname, String image, String email, String phone, String username, String password, String address, int experience, String filecv, String currentposition, String education, String country, String urlinfo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.address = address;
        this.experince = experience;
        this.filecv = filecv;
        this.currentposition = currentposition;
        this.education = education;
        this.country = country;
        this.urlinfo = urlinfo;
    }
    
}
