package com.fiiadmission.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nydiarra on 06/05/17.
 */
@Entity
@Table(name = "admission_data")
public class AdmissionData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cnp")
	private String cnp;

	@Column(name = "adress")
	private String adress;

	@Column(name = "exam_subject")
	private String examSubject;

	@Column(name = "documentType")
	private String documentType;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "bac_grade")
	private Long bacGrade;

	@Column(name = "general_grade")
	private Long generalGrade;

	@Column(name = "graduated_from")
	private String graduatedFrom;

	@Column(name = "civil_state")
	private String civil_state;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	public String getDocument_type() {
		return documentType;
	}

	public void setDocuemnt_type(String docuemnt_type) {
		this.documentType = docuemnt_type;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getBacGrade() {
		return bacGrade;
	}

	public void setBacGrade(Long bacGrade) {
		this.bacGrade = bacGrade;
	}

	public Long getGeneralGrade() {
		return generalGrade;
	}

	public void setGeneralGrade(Long generalGrade) {
		this.generalGrade = generalGrade;
	}

	public String getGraduatedFrom() {
		return graduatedFrom;
	}

	public void setGraduatedFrom(String graduatedFrom) {
		this.graduatedFrom = graduatedFrom;
	}

	public String getCivil_state() {
		return civil_state;
	}

	public void setCivil_state(String civil_state) {
		this.civil_state = civil_state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
