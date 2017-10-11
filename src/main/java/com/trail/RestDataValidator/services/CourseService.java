package com.trail.RestDataValidator.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trail.RestDataValidator.model.Course;
import com.trail.RestDataValidator.model.Topic;

@Service
public class CourseService {

	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("spring", "Spring Framework", "Spring Framework Description")));
	*/
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		//topics.add(topic);
	
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		/*for(int i = 0 ; i < topics.size() ; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
				return;
			}
		}*/
		courseRepository.delete(id);
		
	}

	public void updateCourse(Course course) {
		/*for(int i = 0 ; i < topics.size() ; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic);
				return;
			}
		}*/
		
		addCourse(course);				// Save both Update and save new record . 
	}
}
