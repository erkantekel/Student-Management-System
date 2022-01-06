package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Class;

public interface ClassService {
	
	List<Class> getAllClasses();
	
	Class saveClass(Class class_);
	
	Class getClassById(Long cid);
	
	Class updateClass(Class class_);
	
	void deleteClassById(Long cid);
}
