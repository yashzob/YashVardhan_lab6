package com.StuDebate.StudentReg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StuDebate.StudentReg.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
