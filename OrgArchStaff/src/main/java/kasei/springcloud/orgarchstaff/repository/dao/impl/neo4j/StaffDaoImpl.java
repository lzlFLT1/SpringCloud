package kasei.springcloud.orgarchstaff.repository.dao.impl.neo4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kasei.springcloud.orgarchstaff.repository.dao.StaffDao;

import kasei.springcloud.orgarchstaff.repository.entity.Org;
import kasei.springcloud.orgarchstaff.repository.entity.Staff;

import org.apache.commons.lang3.StringUtils;
import org.neo4j.driver.internal.value.IntegerValue;
import org.neo4j.driver.internal.value.MapValue;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.function.FilterFunction;
import org.neo4j.ogm.cypher.query.Pagination;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;

@Repository
public class StaffDaoImpl implements StaffDao {

    @Autowired @Qualifier("neo4jNotOgmDriver") private Driver driver;
    @Autowired @Qualifier("neo4jSessionFactory") private SessionFactory sessionFactory;


    /** todo 使用非 OGM 方式 */
    @Override
    public boolean batchAdd(Set<Staff> staffSet) {
        /* 生成 uuid */
        Iterator<Staff> iterator = staffSet.iterator();
        while (iterator.hasNext()) {
            iterator.next().setId(UUID.randomUUID().toString());
        }

        org.neo4j.driver.v1.Session notOgmSession = driver.session();
        Map<String, Object> params = new HashMap<>();
        ObjectMapper objMapper = new ObjectMapper();
        String json = null;
        Set<Map> res = null;
        try{
            json = objMapper.writeValueAsString(staffSet);
            res = objMapper.readValue(json, Set.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println(json);
        params.put("props", res);
        String statementTemplate = "unwind $props as properties create (n:Domain:Staff) set n = properties";
        StatementResult sr = notOgmSession.run(statementTemplate, params);
        notOgmSession.close();
        return false;
    }

    /** todo 使用 OGM 方式 */
    @Override
    public boolean deleteById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Set<Filter> filters = new HashSet<>();
        Filter filter = new Filter("id", ComparisonOperator.EQUALS, id);
        filters.add(filter);
        Object delete = session.delete(Staff.class, filters, false);
        transaction.commit();
        transaction.close();
        session.clear();
        return false;
    }


    @Override
    public boolean update(Staff staff) {
        if(StringUtils.isBlank(staff.getId())){
            return false;
        }



        Session session = sessionFactory.openSession();
        //Org load = session.load(Org.class, staff.getId());

        Set<Field> allField = new HashSet<>();



        Field[] fields = Staff.class.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Method[] methods = Staff.class.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
        }
        return false;
    }

    @Override
    public Collection<Staff> loadAll() {
        Session session = sessionFactory.openSession();
        Collection<Staff> staff = session.loadAll(Staff.class);
        session.clear();
        return staff;
    }


    public static Set<Field> getAllFiledRecursive(Class cls){
        if(cls.equals(Object.class)){
            return new HashSet<>();
        } else {
            Class superclass = cls.getSuperclass();
            Set<Field> superFields = getAllFiledRecursive(superclass);
            Field[] selfFields = cls.getDeclaredFields();
            Collections.addAll(superFields, selfFields);
            return superFields;
        }
    }


}
