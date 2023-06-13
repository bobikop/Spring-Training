package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // to be able to print it we use this lombok @ToString annotation
public class Organization {

    public Long id;
    public String name;
    public String contactName;
    public String contactEmail;
    public String contactPhone;

}
