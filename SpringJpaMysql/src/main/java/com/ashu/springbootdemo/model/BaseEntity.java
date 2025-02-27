package com.ashu.springbootdemo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseEntity {
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updateAt;
	private String updatedBy;
}
