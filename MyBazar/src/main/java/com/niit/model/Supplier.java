package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier implements Serializable 
{
	@Id
	private int supplierId;
	private String supplierName;
	private String supplierAddr;
	
	public int getSupplierId() 
	{
		return supplierId;
	}
	public void setSupplierId(int supplierId) 
	{
		this.supplierId = supplierId;
	}
	public String getSupplierName() 
	{
		return supplierName;
	}
	public void setSupplierName(String supplierName) 
	{
		this.supplierName = supplierName;
	}
	public String getSupplierAddr() 
	{
		return supplierAddr;
	}
	public void setSupplierAddr(String supplierAddr) 
	{
		this.supplierAddr = supplierAddr;
	}
	
	
}
