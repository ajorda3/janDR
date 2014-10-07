package si.jandr.engine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

		List<Tool> toolList = session.createQuery("from tool").list();
		return toolList;
	}

	@Override
	@Transactional
	public Tool getToolById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Tool tool = (Tool) session.load(Tool.class, new Integer(id));
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
