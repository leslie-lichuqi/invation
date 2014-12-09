package Dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Invation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Dao.Invation
 * @author MyEclipse Persistence Tools
 */
public class InvationDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(InvationDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String WEIXIN = "weixin";
	public static final String TEL = "tel";
	public static final String AREA = "area";
	public static final String CREATEDATE = "createdate";

	public void save(Invation transientInstance) {
		log.debug("saving Invation instance");
		getSession().clear();
		Transaction t =  getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		t.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(Invation persistentInstance) {
		log.debug("deleting Invation instance");
		getSession().clear();
		Transaction t =  getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		t.commit();
		getSession().flush();
		getSession().close();
	}

	public Invation findById(java.lang.Integer id) {
		log.debug("getting Invation instance with id: " + id);
		try {
			Invation instance = (Invation) getSession().get("Dao.Invation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Invation instance) {
		log.debug("finding Invation instance by example");
		try {
			List results = getSession().createCriteria("Dao.Invation")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Invation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Invation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByWeixin(Object weixin) {
		return findByProperty(WEIXIN, weixin);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByCreatedate(Object createdate) {
		return findByProperty(CREATEDATE, createdate);
	}

	public List findAll() {
		log.debug("finding all Invation instances");
		try {
			String queryString = "from Invation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Invation merge(Invation detachedInstance) {
		log.debug("merging Invation instance");
		try {
			Invation result = (Invation) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Invation instance) {
		log.debug("attaching dirty Invation instance");
		getSession().clear();
		Transaction t =  getSession().beginTransaction();
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		t.commit();
		getSession().flush();
		getSession().close();
	}

	public void attachClean(Invation instance) {
		log.debug("attaching clean Invation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}