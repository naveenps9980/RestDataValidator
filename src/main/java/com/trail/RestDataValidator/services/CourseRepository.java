package com.trail.RestDataValidator.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trail.RestDataValidator.model.Course;

public interface CourseRepository extends CrudRepository<Course, String>{

	public List<Course> findByTopicId(String topicId);
}
