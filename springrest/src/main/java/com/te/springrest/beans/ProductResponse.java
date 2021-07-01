package com.te.springrest.beans;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name = "product-response")
@JsonRootName("productresponse")
public class ProductResponse {
	
	
	@XmlElement
	@JsonProperty
	private int statusCode;
	
	@Column
	@XmlElement
	@JsonProperty
	private String msg;
	
	
	@XmlElement
	@JsonProperty
	private Product product;

}
