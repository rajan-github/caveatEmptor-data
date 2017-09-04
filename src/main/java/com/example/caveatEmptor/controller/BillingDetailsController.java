package com.example.caveatEmptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.caveatEmptor.exception.BillingDetailNotFoundException;
import com.example.caveatEmptor.model.inheritance.BillingDetails;
import com.example.caveatEmptor.service.BillingDetailsService;

import com.example.caveatEmptor.util.Error;

@RestController
@RequestMapping("/billingDetails")
public class BillingDetailsController {

	@Autowired
	private BillingDetailsService billingDetailService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public BillingDetails billingDetailById(@PathVariable Long id) {
		BillingDetails billingDetail = billingDetailService.findOne(id);
		if (billingDetail == null) {
			throw new BillingDetailNotFoundException(id);
		}
		return billingDetail;
	}

	@ExceptionHandler(BillingDetailNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error billingDetailNotFound(BillingDetailNotFoundException e) {
		Long billingDetailId = e.getBillingDetailId();
		return new Error(4, "BillingDetail [ " + billingDetailId + " ] not found.");

	}
}
