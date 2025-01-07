package com.find.flat_buddies.model;

import jakarta.persistence.*;
import lombok.*;
//import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@Table(name = "UserTable")
public class User {


    @GeneratedValue(strategy = SEQUENCE)
    @Id
    private Long id;

    @Column
    private String userFName;

    @Column
    private String userLName;

    @Column
    private String gender;

    @Column(unique = true)
    private String emailId;

    @Column
    private Boolean employmentStatus;

    @Column
    private String companyName;

    @Column
    private String education;

    @Column
    private String homeTown;

    @Column
    private Long contactNumber;

    public User() {
        super();
    }

    public User(String userFName, Long id, String userLName, String gender, String emailId, Boolean employmentStatus, String companyName, String education, String homeTown, Long contactNumber) {
        this.userFName = userFName;
        this.id = id;
        this.userLName = userLName;
        this.gender = gender;
        this.emailId = emailId;
        this.employmentStatus = employmentStatus;
        this.companyName = companyName;
        this.education = education;
        this.homeTown = homeTown;
        this.contactNumber = contactNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(Boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
