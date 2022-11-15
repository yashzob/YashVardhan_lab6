package com.StuDebate.StudentReg.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lambok
@Data
@Getter
@Setter
@NoArgsConstructor

//Defining Role Table
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private int roleId;
	
	@Column(name="roleName")
	private String roleName;

	//private List<User> users = new ArrayList<>();
	
}
