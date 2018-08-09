package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;
import com.niit.test.SupplierDAOTestCase;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int id);
	
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier();
}
