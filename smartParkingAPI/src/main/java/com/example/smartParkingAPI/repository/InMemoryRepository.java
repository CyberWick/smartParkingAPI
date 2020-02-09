package com.example.smartParkingAPI.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.example.smartParkingAPI.domain.Identifiable;

public abstract class InMemoryRepository<T extends Identifiable> {

	private List<T> elements = Collections.synchronizedList(new ArrayList<>());

	public T create(T element) {
		elements.add(element);
		return element;
	}

	public boolean delete(String vehicle_no) {
		return elements.removeIf(element -> element.getId().equals(vehicle_no));
	}

	public List<T> findAll() {
		return elements;
	}

	public Optional<T> findById(String id) {
		return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
	}

	public int getCount() {
		return elements.size();
	}

	public void clear() {
		elements.clear();
	}

	public boolean update(String id, T updated) {
		
		if (updated == null) {
			return false;
		}
		else {
			Optional<T> element = findById(id);
			element.ifPresent(original -> updateIfExists(original, updated));
			return element.isPresent();
		}
	}
	protected abstract void updateIfExists(T original, T desired);
}