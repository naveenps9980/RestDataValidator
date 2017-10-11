package com.trail.RestDataValidator.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trail.RestDataValidator.model.Topic;

@Service
public class TopicService {

	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("spring", "Spring Framework", "Spring Framework Description")));
	*/
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		/*for(int i = 0 ; i < topics.size() ; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
				return;
			}
		}*/
		topicRepository.delete(id);
		
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i = 0 ; i < topics.size() ; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic);
				return;
			}
		}*/
		
		addTopic(topic);				// Save both Update and save new record . 
	}
}
