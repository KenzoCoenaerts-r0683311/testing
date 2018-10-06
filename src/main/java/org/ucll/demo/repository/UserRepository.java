package org.ucll.demo.repository;

import java.util.List;

import org.ucll.demo.domain.BmiUser;

public interface UserRepository {

	public abstract void add(BmiUser object);
	
	public abstract void update(BmiUser object);

	public abstract List<BmiUser> getAll();

	public abstract BmiUser get(String id);

	public abstract void delete(BmiUser object);

	public abstract void delete(String id);
}
