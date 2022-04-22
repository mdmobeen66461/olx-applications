package com.zensar.olxadvertise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertise {
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
