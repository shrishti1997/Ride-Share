package com.intern.users.model;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Setter
@Getter
public class Users {

    @Id
    private String user_id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private int mobile;
    @NotNull
    private String aadhar;
    @NotNull
    private float rating;
}
