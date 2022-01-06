package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Class;
import net.javaguides.sms.repository.ClassRepository;
import net.javaguides.sms.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
		
		private ClassRepository classRepository;
		
		public ClassServiceImpl(ClassRepository classRepository) {
			super();
			this.classRepository = classRepository;
		}
		
		@Override
		public List<Class> getAllClasses() {
			return classRepository.findAll();
		}

		@Override
		public Class saveClass(Class class_) {
			return classRepository.save(class_);
		}

		@Override
		public Class getClassById(Long cid) {
			return classRepository.findById(cid).get();
		}

		@Override
		public Class updateClass(Class class_) {
			return classRepository.save(class_);
		}

		@Override
		public void deleteClassById(Long cid) {
			classRepository.deleteById(cid);	
		}

	}
