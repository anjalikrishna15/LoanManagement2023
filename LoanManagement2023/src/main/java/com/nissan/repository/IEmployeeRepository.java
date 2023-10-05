//package com.nissan.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.nissan.dto.EmployeeDeptDTO;
//import com.nissan.entity.Employee;
//@Repository
//public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {
//	// search by name
//    //custom methods using JPQL query
//	@Query("from Employee where employeeName like %?1%")
//	public List<Employee> findByEmployeeName(String name);
//	// inner join
//	@Query("SELECT new com.nissan.dto.EmployeeDeptDTO(e.id,e.employeeName,e.designation,d.departmentName) FROM Employee e INNER JOIN e.department d ORDER BY e.id")
//	public List<EmployeeDeptDTO> getAllDtoEmployees();
//	
//	@Modifying
//	@Query("update com.nissan.entity.Employee set isActive=0 where id=?1 ")
//	public void deleteEmployee(Integer id);
//	
//}
