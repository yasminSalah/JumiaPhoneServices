package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "customer")
public class Customer {

	@Id
	// @Column(name = "Id")
	// @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	// @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	// @GeneratedValue
	private int id;
	private String name;
	private String phone;


}
