package org.ucll.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ucll.demo.domain.BmiUser;

public class UserStubRepository implements UserRepository {

	private static Map<String, BmiUser> db;
	
	public UserStubRepository() {
		if(db == null){
			db = new HashMap<String, BmiUser>();
			BmiUser user1 = new BmiUser();
			user1.setUserid("ElSte");
			user1.setPassword("qwerty123");
			add(user1);
			BmiUser user2 = new BmiUser();
			user2.setUserid("MieKem");
			user2.setPassword("azerty999");
			add(user2);
		}
	}

	public void add(BmiUser object) {
		if(object == null){
			throw new IllegalArgumentException("error.no.person");
		}
		if(get(object.getUserid()) == null){
			db.put(object.getUserid().toLowerCase(), object);
		}
	}

	public void update(BmiUser object) {
		if(object == null){
			throw new IllegalArgumentException("error.person.not.found");
		}
		db.put(object.getUserid().toLowerCase(), object);
	}

	public List<BmiUser> getAll() {
		return new ArrayList<BmiUser>(db.values());
	}

	public BmiUser get(String id) {
		if(id == null){
			throw new IllegalArgumentException("error.no.valid.id");
		}
		return (BmiUser) db.get(id.toLowerCase());
	}

	public void delete(BmiUser object) {
		if(object == null){
			throw new IllegalArgumentException("error.no.person");
		}
		db.remove(object.getUserid().toLowerCase());
	}

	@Override
	public void delete(String id) {
		if(id == null){
			throw new IllegalArgumentException("error.no.socialsecuritynumber");
		}
		db.remove(id.toLowerCase());
	}

}
