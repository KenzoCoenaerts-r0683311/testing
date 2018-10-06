package org.ucll.demo.service.api.java.assembler;

import org.ucll.demo.domain.BmiUser;
import org.ucll.demo.service.api.java.to.UserDetail;

public class UserToAssembler {

    public UserDetail creatUserDetailTo(BmiUser person) {
    	UserDetail to = new UserDetail();
        to.setUserid(person.getUserid());
        to.setPassword(person.getPassword());
        
        return to;
    }

    public BmiUser createUser(UserDetail to) {
    	BmiUser person = new BmiUser();
    	person.setUserid(to.getUserid());
    	person.setPassword(to.getPassword());
		return person;
	}
}
