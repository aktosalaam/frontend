package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Service

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	@Transactional
	public boolean addSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();

		try {
			session.saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			session.close();
		}

	}

	/*
	 * Updating details
	 */
	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();

		try {
			session.update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			session.close();
		}

	}

	@Transactional
	public boolean deleteSupplier(int id) {
		/* Session session = sessionFactory.openSession(); */

		Supplier supplier1 = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, id);
		try {
			if (null != supplier1) {
				sessionFactory.getCurrentSession().delete(supplier1);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			// session.close();
		}

	}

	// Getting single supplier details by id
	@Transactional
	public Supplier getSupplier(int sid) {
		Session session = sessionFactory.openSession();

		Supplier supplier = (Supplier) session.get(Supplier.class, sid);

		session.close();
		return supplier;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Supplier> listSupplier() {
		List<Supplier> suppList = new ArrayList<Supplier>();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM Supplier");
		suppList = query.list();

		session.close();
		return suppList;

	}

}