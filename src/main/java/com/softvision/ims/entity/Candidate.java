package com.softvision.ims.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * The Class Candidate.
 *
 * @author arun.p
 */

public class Candidate extends CommonEntity implements Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    private String candidateId;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The gender. */
    private String gender;

    /** The technology stack. */
    private String technologyStack;

    /** The is active. */
    private Boolean isActive;

    /** The experiance. */
    private String experiance;

    /** The phone number. */
    private String phoneNumber;

    /** The email. */
    private String email;

    /** The unique identity number. */
    private String uniqueIdentityNumber;

    /** The interview details. */
    private String interviewDetails;


    /**
     * Gets the candidate id.
     *
     * @return the candidate id
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * Sets the candidate id.
     *
     * @param candidateId the new candidate id
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the technology stack.
     *
     * @return the technology stack
     */
    public String getTechnologyStack() {
        return technologyStack;
    }

    /**
     * Sets the technology stack.
     *
     * @param technologyStack the new technology stack
     */
    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }

    /**
     * Gets the checks if is active.
     *
     * @return the checks if is active
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets the checks if is active.
     *
     * @param isActive the new checks if is active
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets the experiance.
     *
     * @return the experiance
     */
    public String getExperiance() {
        return experiance;
    }

    /**
     * Sets the experiance.
     *
     * @param experiance the new experiance
     */
    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the unique identity number.
     *
     * @return the unique identity number
     */
    public String getUniqueIdentityNumber() {
        return uniqueIdentityNumber;
    }

    /**
     * Sets the unique identity number.
     *
     * @param uniqueIdentityNumber the new unique identity number
     */
    public void setUniqueIdentityNumber(String uniqueIdentityNumber) {
        this.uniqueIdentityNumber = uniqueIdentityNumber;
    }

    /**
     * Gets the interview details.
     *
     * @return the interview details
     */
    public String getInterviewDetails() {
        return interviewDetails;
    }

    /**
     * Sets the interview details.
     *
     * @param interviewDetails the new interview details
     */
    public void setInterviewDetails(String interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

}
