package com.find.flat_buddies.model;

import jakarta.persistence.*;
import lombok.*;
//import jakarta.persistence.Id;

import java.util.List;


@Entity
@ToString
@Table(name = "UserTable")
public class User {

    public enum roles{
        ADMIN, USER
    };

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
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
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private roles role;

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
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<PropertyDetails> property;

    public User() {
        super();
    }

    public User(Long id, String userFName, String userLName, String gender, String emailId, String password, roles role, Boolean employmentStatus, String companyName, String education, String homeTown, Long contactNumber, List<PropertyDetails> property) {
        this.id = id;
        this.userFName = userFName;
        this.userLName = userLName;
        this.gender = gender;
        this.emailId = emailId;
        this.password = password;
        this.role = role;
        this.employmentStatus = employmentStatus;
        this.companyName = companyName;
        this.education = education;
        this.homeTown = homeTown;
        this.contactNumber = contactNumber;
        this.property = property;
    }
    
    

    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

	/**
	 * @return the property
	 */
	public List<PropertyDetails> getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(List<PropertyDetails> property) {
		this.property = property;
	}


}
