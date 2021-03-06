package com.pernix.einvoicing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Services implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "lineNumber")
	private int lineNumber;

	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceId", nullable = true)
	List<Code> codeList = new ArrayList<Code>();

	@Column(nullable = false, name = "amount")
	private int amount;

	@Column(nullable = false, name = "unitOfMeasurementType")
	private String unitOfMeasurementType;

	@Column(nullable = false, name = "unitOfMeasurementName")
	private String unitOfMeasurementName;

	@Column(nullable = false, name = "comercialUnitOfMeasurement")
	private String comercialUnitOfMeasurement;

	@Column(nullable = false, name = "detail")
	private String detail;

	@Column(nullable = false, name = "priceByUnit")
	private double priceByUnit;

	@Column(nullable = false, name = "totalAmount")
	private double totalAmount;

	@Column(nullable = false, name = "discount")
	private double discount;

	@Column(nullable = true, name = "discountNature")
	private String discountNature;

	@Column(nullable = false, name = "subTotal")
	private double subTotal;

	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceId", nullable = true)
	List<Tax> taxList = new ArrayList<Tax>();

	@Column(nullable = false, name = "total")
	private double total;

	public Services() {
	}

	public Services(Long id, int lineNumber, List<Code> codeList, int amount, String unitOfMeasurementType,
			String unitOfMeasurementName, String comercialUnitOfMeasurement, String detail, double priceByUnit,
			double totalAmount, double discount, String discountNature, double subTotal, List<Tax> taxList,
			double total) {
		super();
		this.id = id;
		this.lineNumber = lineNumber;
		this.codeList = codeList;
		this.amount = amount;
		this.unitOfMeasurementType = unitOfMeasurementType;
		this.unitOfMeasurementName = unitOfMeasurementName;
		this.comercialUnitOfMeasurement = comercialUnitOfMeasurement;
		this.detail = detail;
		this.priceByUnit = priceByUnit;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.discountNature = discountNature;
		this.subTotal = subTotal;
		this.taxList = taxList;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public List<Code> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<Code> codeList) {
		this.codeList = codeList;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnitOfMeasurementType() {
		return unitOfMeasurementType;
	}

	public void setUnitOfMeasurementType(String unitOfMeasurementType) {
		this.unitOfMeasurementType = unitOfMeasurementType;
	}

	public String getUnitOfMeasurementName() {
		return unitOfMeasurementName;
	}

	public void setUnitOfMeasurementName(String unitOfMeasurementName) {
		this.unitOfMeasurementName = unitOfMeasurementName;
	}

	public String getComercialUnitOfMeasurement() {
		return comercialUnitOfMeasurement;
	}

	public void setComercialUnitOfMeasurement(String comercialUnitOfMeasurement) {
		this.comercialUnitOfMeasurement = comercialUnitOfMeasurement;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getPriceByUnit() {
		return priceByUnit;
	}

	public void setPriceByUnit(double priceByUnit) {
		this.priceByUnit = priceByUnit;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDiscountNature() {
		return discountNature;
	}

	public void setDiscountNature(String discountNature) {
		this.discountNature = discountNature;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public List<Tax> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<Tax> taxList) {
		this.taxList = taxList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}