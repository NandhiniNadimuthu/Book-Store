package com.nn.BookStoreMaven.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Author {
    int id;
    String name;
    Date DOB;
    String place;
    int phone;
}
