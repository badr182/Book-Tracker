package io.javabrains.userBooks;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.Data;

@Data
@PrimaryKeyClass
public class UserBooksPrimaryKey {
	
	@PrimaryKeyColumn(name="user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String userId;
	
	@PrimaryKeyColumn(name="book_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String bookId;

}
