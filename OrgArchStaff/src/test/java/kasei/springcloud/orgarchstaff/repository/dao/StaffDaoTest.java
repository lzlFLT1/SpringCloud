package kasei.springcloud.orgarchstaff.repository.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import kasei.springcloud.orgarchstaff.OrgArchStaffApplication;
import kasei.springcloud.orgarchstaff.repository.dao.impl.neo4j.StaffDaoImpl;
import kasei.springcloud.orgarchstaff.repository.entity.Staff;
import org.junit.jupiter.api.Test;
import org.neo4j.ogm.id.IdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = OrgArchStaffApplication.class)
class StaffDaoTest {

    @Autowired StaffDao staffDao;

    @Test
    void batchAdd() {

        Set<Staff> set = new HashSet<>();
        Staff s1 = new Staff();
        // s1.setId("87a7ebd2-f052-47dd-95a9-7d603f909ad1");
        s1.setAccount("10000001");
        s1.setNickName("kasei");
        set.add(s1);
         Staff s2 = new Staff();
        // s2.setId(UUID.randomUUID().toString());
        s2.setAccount("10000002");
        s2.setNickName("haku");
        set.add(s2);


        staffDao.batchAdd(set);

    }


    @Test
    void batchDeleteById(){
        Class<? super Object> superclass = Object.class.getSuperclass();
        Type genericSuperclass = Object.class.getGenericSuperclass();
        AnnotatedType annotatedSuperclass = Object.class.getAnnotatedSuperclass();
        System.out.println(superclass);
        //Neo4jRepository
    }
    @Test
    void update(){
        Set<Field> allFiledRecursive = StaffDaoImpl.getAllFiledRecursive(Staff.class);

        Iterator<Field> iterator = allFiledRecursive.iterator();
        for (Field field : allFiledRecursive) {
            System.out.println(field.getName());
        }


    }


}