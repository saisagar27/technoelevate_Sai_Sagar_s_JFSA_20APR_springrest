package com.te.springrest.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table
@XmlRootElement(name = "product-info")
@JsonRootName("productinfo")

public class Product implements Serializable{
	@Id
	@Column
	@XmlElement
	@JsonProperty
	private int pid;
	
	@Column
	@XmlElement
	@JsonProperty
	private String pname;
	
	@Column
	@XmlElement
	@JsonProperty
	private Date mfgDate;
	
	@Column
	@XmlTransient
	@JsonIgnore
	private Date expDate;
	
	@Column
	@XmlElement
	@JsonProperty
	private int price;

}
