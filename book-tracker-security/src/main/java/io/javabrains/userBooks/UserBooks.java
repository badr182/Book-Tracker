package io.javabrains.userBooks;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

import lombok.Data;

@Data
@Table(value = "book_by_user_and_bookid")
public class UserBooks {
	
	@PrimaryKey 
	private UserBooksPrimaryKey key;
	
	@Column("reading_status")
	@CassandraType(type = Name.TEXT)
	private String readingStatus;
	
	@Column("satrted_date")
	@CassandraType(type = Name.DATE)
	private LocalDate  startedDate;
	
	@Column("completed_date")
	@CassandraType(type = Name.DATE)
	private LocalDate  completedDate;
	
	@Column("rating")
	@CassandraType(type = Name.INT)
	private int rating;
	
	
	
}
