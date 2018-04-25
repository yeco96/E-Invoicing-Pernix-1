package com.pernix.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pernix.spring.model.Tax;
import com.pernix.spring.services.TaxService;

@RestController
public class TaxController {
 
	private TaxService taxService = new TaxService();

	@RequestMapping("/addTax")
	public void addTax(
			@RequestParam String code, 
			@RequestParam String rate, 
			@RequestParam String purchasePercentage, 
			@RequestParam String date,
			@RequestParam String institutionName, 
			@RequestParam String documentNumber,
			@RequestParam String documentType) throws Exception {
		
		Tax tax = new Tax();
		tax.setCode(code);
		tax.setRate(rate);
		tax.setPurchasePercentage(purchasePercentage);
		tax.setDate(date);
		tax.setInstitutionName(institutionName);
		tax.setDocumentNumber(documentNumber);
		tax.setDocumentType(documentType);

		try {
			taxService.addTax(tax);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping("/getTaxes")
	public String getTaxes() throws Exception {
		Gson gson = new Gson();
		try {
			String jsonService = gson.toJson(taxService.getAllTaxes());
			return jsonService;
		} catch (Exception e) {
			throw e;
		}
	}
}