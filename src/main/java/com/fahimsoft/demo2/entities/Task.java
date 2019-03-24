package com.fahimsoft.demo2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String startTime;
	@NotEmpty
	private String stopTime;
	@NotEmpty
	@Column(length=1000)
	private String description;
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;
}
