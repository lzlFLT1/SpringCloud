package kasei.springcloud.orgarchstaff.repository.dao.impl.neo4j;

import kasei.springcloud.orgarchstaff.repository.dao.OrgDao;
import kasei.springcloud.orgarchstaff.repository.entity.Org;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.Method;

public class OrgDaoImpl implements OrgDao {
    @Autowired
    @Qualifier("neo4jSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean insert(Iterable<Org> orgs) {
        Session session = sessionFactory.openSession();
        session.save(orgs);
        session.clear();
        return false;
    }

    @Override
    public boolean delete(Iterable<Org> orgs) {
        Session session = sessionFactory.openSession();
        session.delete(orgs);
        session.clear();
        return false;
    }

    @Override
    public boolean update(Org org) {
        Session session = sessionFactory.openSession();
        Org load = session.load(Org.class, org.getId());
        Method[] methods = Org.class.getMethods();

        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
        }
        return false;
    }



}
