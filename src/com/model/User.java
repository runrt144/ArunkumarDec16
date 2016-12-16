package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="capstone.registration")
public class User implements Serializable {
	@Id
	private String email;
	
	private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String confirm_password;
    private String gender;
    private String zip;
    private String phone_no;

    public User() {
    }

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the confirm_password
	 */
	public String getConfirm_password() {
		return confirm_password;
	}

	/**
	 * @param confirmpassword the confirm_password to set
	 */
	public void setConfirmpassword(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	/**
	 * @return the lastName
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the phone_no
	 */
	public String getPhone_no() {
		return phone_no;
	}

	/**
	 * @param phonenumber the phone_no to set
	 */
	public void setPhonenumber(String phone_no) {
		this.phone_no = phone_no;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param confirmpassword
	 * @param zip
	 * @param phonenumber
	 */
	public User(String id, String firstName, String lastName, String email, String password, String confirm_password, String gender, String zip,
			String phone_no) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
		this.gender = gender;
		this.zip = zip;
		this.phone_no = phone_no;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	public User(String firstName, String lastName, String password, String confirm_password, String gender, String zip,
			String phone_no) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirm_password = confirm_password;
		this.gender = gender;
		this.zip = zip;
		this.phone_no = phone_no;
	}
}