package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

//	List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(100, "Java Core", "This is Java fundamental course"));
//		list.add(new Course(101, "Spring Boot", "This is Spring boot course"));
	}
	
	@Override
	public List<Course> getCourses() {		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course course=null;
//		
//		for(Course c: list) {
//			if(c.getId()==courseId) {
//				course = c;
//				break;
//			}
//		}
		
		return courseDao.getReferenceById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.forEach(e-> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		
		Course entity = courseDao.getReferenceById(courseId);
		courseDao.delete(entity);
	}
	
}
