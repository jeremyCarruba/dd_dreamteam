package com.campus.campus;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampusApplication {
	public static void main(MysqlxDatatypes.Scalar.String[] args) {
		SpringApplication.run(CampusApplication.class, args);
	}
}
