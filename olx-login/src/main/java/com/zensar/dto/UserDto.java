package com.zensar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel("This is the model")

public class UserDto {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Id
//	@ApiModelProperty("stock Id of Integer type")
	private long id;
//	@ApiModelProperty("firstname of String type")
	private String firstName;
//	@ApiModelProperty("lastname of String type")
	private String lastName;
//	@ApiModelProperty("username of String type")
	private String userName;
//	@ApiModelProperty("password of String type")
	private String password;
//	@ApiModelProperty("email of String type")
	private String email;
//	@ApiModelProperty("email of Integer type")
	private long phone;

}
