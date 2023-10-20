package com.auth.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.auth.domain.User;

//@Repository
public interface UserRepository extends CassandraRepository<User, String> {

	Optional<User> findByUsername(String username);

}
