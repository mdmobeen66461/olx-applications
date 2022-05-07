package com.zensar.olxmaster.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel("This is the model")
@Entity
public class Status {
	//@ApiModelProperty("Id of Integer type")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	//@ApiModelProperty("Status of String type")
	private String status;

}
