package kasei.springcloud.orgarchstaff.repository.dao;

import kasei.springcloud.orgarchstaff.repository.entity.Staff;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface StaffDao {


    default public boolean batchAdd(Set<Staff> staffSet){
        return false;
    }

    default public boolean deleteById(String id) {
        return false;
    }

    /** todo 更新一个实例
     * @trap 参数 staff 实例 id 属性不能为 null
     * */
    default public boolean update(Staff staff) {
        return false;
    }


    default public Collection<Staff> loadAll(){return new HashSet<>();}

    default public Staff getById(String id){
        Staff staff = new Staff();
        staff.setAccount(null);
        staff.setNickName("用户不存在");
        return staff;
    }
}
