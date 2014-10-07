package si.jandr.engine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import si.jandr.engine.models.Location;

public class LocationDAOImpl implements LocationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addLocation(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(location);
	}

	@Override
	@Transactional
	public void updateLocation(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(location);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Location> listLocations() {
		Session session = this.sessionFactory.getCurrentSession();

		List<Location> locationList = session.createQuery("from location").list();
		return locationList;
	}

	@Override
	@Transactional
	public Location getLocationById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Location location = (Location) session.load(Location.class, new Integer(id));
		return location;
	}

	@Override
	@Transactional
	public void removeLocation(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Location location = (Location) session.load(Location.class, new Integer(id));
		if ( location != null ) {
			session.delete(location);
		}

	}

}
