package com.example.smartParkingAPI.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartParkingAPI.domain.Vehicles;
import com.example.smartParkingAPI.repository.VehicleRepository;
import com.example.smartParkingAPI.resource.VehicleResource;
import com.example.smartParkingAPI.resource.VehicleResourceAssembler;

@CrossOrigin(origins = "*")
@RestController
@org.springframework.hateoas.ExposesResourceFor(Vehicles.class)
@RequestMapping(value = "/vehicles", produces = "application/json")
public class RESTcontroller {
	
	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private VehicleResourceAssembler assembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<VehicleResource>> findAllOrders() {
		List<Vehicles> orders = repository.findAll();
		return new ResponseEntity<>(assembler.toResourceCollection(orders), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<VehicleResource> createOrder(@RequestBody Vehicles order) {
		Vehicles createdOrder = repository.create(order);
		return new ResponseEntity<>(assembler.toResource(createdOrder), HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<VehicleResource> findOrderById(@PathVariable String id) {
//		Optional<Vehicles> order = repository.findById(id);
//
//		if (order.isPresent()) {
//			return new ResponseEntity<>(assembler.toResource(order.get()), HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
		boolean wasDeleted = repository.delete(id);
		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(responseStatus);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<VehicleResource> updateOrder(@PathVariable String id, @RequestBody Vehicles updatedOrder) {
		boolean wasUpdated = repository.update(id, updatedOrder);	
		if (wasUpdated) {
			return findOrderById(id);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<VehicleResource> findOrderById(@RequestParam(name="vc_no", required=true, defaultValue="") String vehicle_no) {
		Optional<Vehicles> order = repository.findById(vehicle_no);
		if (order.isPresent()) {
			return new ResponseEntity<>(assembler.toResource(order.get()), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
//	@RequestMapping(value = "/lot", method = RequestMethod.GET)
//	public ResponseEntity<String> findMyLot_no(@RequestParam(name="vc_no", required=true, defaultValue="") String vehicle_no) {
//		Optional<Vehicles> order = repository.findById(vehicle_no);
//		if (order.isPresent()) {
//			return new ResponseEntity<>(assembler.toResource(order.get()).getLot_name(), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
