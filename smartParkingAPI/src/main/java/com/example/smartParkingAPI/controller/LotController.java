package com.example.smartParkingAPI.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartParkingAPI.domain.ParkingLot;
import com.example.smartParkingAPI.repository.LotRepository;
import com.example.smartParkingAPI.resource.LotResource;
import com.example.smartParkingAPI.resource.LotResourceAssembler;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(ParkingLot.class)
@RequestMapping(value = "/lot", produces = "application/json")
public class LotController {
	
	@Autowired
	private LotRepository repository;
	
	@Autowired
	private LotResourceAssembler assembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<LotResource>> findAllLots() {
		List<ParkingLot> lots = repository.findEmpty();
		return new ResponseEntity<>(assembler.toResourceCollection(lots), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/nextFree" ,method = RequestMethod.GET)
	public ResponseEntity<LotResource> findNextFree() {
		ParkingLot lot = repository.findNext();
		if(lot != null)
			return new ResponseEntity<>(assembler.toResource(lot), HttpStatus.OK);
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LotResource> createLot(@RequestBody ParkingLot lot) {
		ParkingLot createdLot = repository.create(lot);
		return new ResponseEntity<>(assembler.toResource(createdLot), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<LotResource> findLotById(@RequestParam(name = "lot_no", required = true,defaultValue = "") String id) {
		Optional<ParkingLot> lot = repository.findById(id);

		if (lot.isPresent()) {
			return new ResponseEntity<>(assembler.toResource(lot.get()), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLot(@PathVariable String id) {
		boolean wasDeleted = repository.delete(id);
		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(responseStatus);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<LotResource> updateLot(@PathVariable String id, @RequestBody ParkingLot updatedLot) {
		boolean wasUpdated = repository.update(id, updatedLot);
		
		if (wasUpdated) {
			return findLotById(id);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

