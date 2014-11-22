package si.jandr.engine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;

import si.jandr.engine.models.Tool;

public class ToolDAOImpl implements ToolDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addTool(Tool tool) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tool);
	}

	@Override
	@Transactional
	public void updateTool(Tool tool) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tool);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tool> listTools() {
		Session session = this.sessionFactory.getCurrentSession();

		List<Tool> toolList = session.createQuery("from Tool").list();
		return toolList;
	}

	@Override
	@Transactional
	public Tool getToolById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Tool> tools = session.createCriteria(Tool.class)
						.add(Restrictions.eq("id", 1)).list();
		
		Tool tool = tools.get(0);
		
//		Tool tool = (Tool) session.load(Tool.class, new Integer(id));
		return tool;
	}

	@Override
	@Transactional
	public void removeTool(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Tool tool = (Tool) session.load(Tool.class, new Integer(id));
		if (null != tool) {
			session.delete(tool);
		}

	}

}
