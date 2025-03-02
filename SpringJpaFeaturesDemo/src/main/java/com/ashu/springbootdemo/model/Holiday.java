package com.ashu.springbootdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

	@Id
	private String day;
	private String reason;

	@Enumerated(EnumType.STRING)
	private Type type;

	public enum Type {
		FESTIVAL, FEDERAL;
	}

}
