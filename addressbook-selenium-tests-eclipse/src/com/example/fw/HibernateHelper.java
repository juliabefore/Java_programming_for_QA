package com.example.fw;

import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupData> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<GroupData>(
              (List<GroupData>) session.createQuery("from GroupData").list());
		} finally {
          trans.commit();
		}
	}

	public List<ContactData> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<ContactData>(
              (List<ContactData>) session.createQuery("from ContactData").list());
		} finally {
          trans.commit();
		}
	}

	public List<ContactData> listContactsFull() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<ContactData>(
              (List<ContactData>) session.createSQLQuery("select t1.id as id, t1.firstname as firstname, t1.lastname as lastname, t1.address as address, t1.home as home,t1.mobile as mobile, t1.work as work, t1.email as email, t1.email2 as email2, t1.bday as bday, t1.bmonth as bmonth, t1.byear as byear, t1.address2 as address2, t1.phone2 as phone2, t2.group_id as group_id from addressbook t1 left join address_in_groups t2 on t1.id=t2.id").addEntity(ContactData.class).list());
		} finally {
          trans.commit();
		}
	}
}
