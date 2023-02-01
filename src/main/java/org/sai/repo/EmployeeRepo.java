package org.sai.repo;

import org.sai.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeInfo,Long> {

}
