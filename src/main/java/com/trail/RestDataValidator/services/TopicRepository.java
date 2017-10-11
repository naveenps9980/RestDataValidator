package com.trail.RestDataValidator.services;

import org.springframework.data.repository.CrudRepository;

import com.trail.RestDataValidator.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
