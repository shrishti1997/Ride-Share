package com.intern.trip.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.lang.annotation.Documented;

@Document
@Getter
@Setter
public class Trip {

    String states[] = {"planning in progress", "planning completed", "deleted"};
    private String status = states[0];
    int trip_existing_partc = 1;


    @Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String generated_trip_id;
    @NotNull
    private String trip_org_email;
    @NotNull
    private String trip_source;
    @NotNull
    private String trip_destination;
    @NotNull
    private String trip_date;//type = date
    @NotNull
    private String trip_time;// type = time
    @NotNull
    private int trip_max_partc;
}
