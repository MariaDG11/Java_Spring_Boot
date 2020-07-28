package com.gruptwo.finalProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gruptwo.finalProject.entities.Container;
import com.gruptwo.finalProject.repository.ContainerRepository;

@Service
public class ContainerService {
	
	@Autowired
	ContainerRepository containerRep;
	
	
	//Save Container method
	public Container saveContainer(Container container) {
		return containerRep.save(container);		
	}// end method save
	
	//Delete a Container by its id
	public void deleteContainer(Integer id) {
		try {
			containerRep.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete
	
	//List all Container	
	public List<Container> containerList()	{
		return containerRep.findAll();
	}//End list method
	
	//Search a Container by its id
	public Container getContainerById(Integer id) {
		return containerRep.findById(id).get();
	}
	
	
		

}
