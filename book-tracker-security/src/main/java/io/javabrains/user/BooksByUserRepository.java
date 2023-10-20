package io.javabrains.user;

import java.awt.print.Pageable;

import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Slice;

public interface BooksByUserRepository extends CassandraRepository<BooksByUser, String> {
	
    Slice<BooksByUser> findAllById(String id, CassandraPageRequest cassandraPageRequest);

}
