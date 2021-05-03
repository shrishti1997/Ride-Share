package com.intern.trip.repo;

import com.intern.trip.model.Trip;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends CouchbaseRepository<Trip, String> {
}
