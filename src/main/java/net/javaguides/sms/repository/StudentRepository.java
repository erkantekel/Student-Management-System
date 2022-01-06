package net.javaguides.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
 
	@Query(value="select * from students where class_name=?1", nativeQuery=true)
	public List<Student> getStudentByClassName(String className);
}
