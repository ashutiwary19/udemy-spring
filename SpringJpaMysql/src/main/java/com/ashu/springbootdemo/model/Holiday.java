package com.ashu.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holiday extends BaseEntity {
	private String day;
	private String reason;
	private Type type;

	public enum Type {
		FESTIVAL, FEDERAL;
	}

}
