package org.ucll.demo.ui;

import java.io.Serializable;

import org.ucll.demo.service.api.java.PersonServiceJavaApi;

public class ServiceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private PersonServiceJavaApi service;

	public ServiceBean() {
		super();
		service = new PersonServiceJavaApi();
	}

	public PersonServiceJavaApi getService() {
		return service;
	}

}