package com.intern.users.repo;

import com.intern.users.model.Users;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends CouchbaseRepository<Users, String > {
}
