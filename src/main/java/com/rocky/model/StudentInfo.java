package com.rocky.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sId;
	
	private String sName;
	
	private String sCity;
	
	@Lob
	@Column(length=100000)
	private byte[] image;
	
	@Lob
	private char[] textfile;
	
	
	
	public StudentInfo() {
		
		System.out.println("Zero Param Consructor for Hibernate");
	}

	
	
	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public char[] getTextfile() {
		return textfile;
	}



	public void setTextfile(char[] textfile) {
		this.textfile = textfile;
	}



	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		return "StudentInfo [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + ", image=" + Arrays.toString(image)
				+ ", textfile=" + Arrays.toString(textfile) + "]";
	}
	
	

}
