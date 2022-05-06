package com.zensar.olxadvertise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("This is the model")
@Entity
public class Advertise {
	  //@ApiModelProperty("Id of Integer type")
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Id
       private long id;
       private String title;
       private double price;
       private String category;
       private String description;
       private String userName;
       private String createdDate;
       private String modifiedDate;
       private String status;
}
