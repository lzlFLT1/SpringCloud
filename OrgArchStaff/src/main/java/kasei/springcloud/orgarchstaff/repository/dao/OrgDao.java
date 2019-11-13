package kasei.springcloud.orgarchstaff.repository.dao;

import kasei.springcloud.orgarchstaff.repository.entity.Org;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface OrgDao {


    /** todo 批量插入
     * @trap
     * */
    default public boolean insert(Iterable<Org> orgs){

        return false;
    }
    /** todo 批量删除
     * @trap orgs 中的实例 id 属性不能为空
     * */
    default public boolean delete(Iterable<Org> orgs){
        return false;
    }
    /** todo 更新
     * @trap 只更新 org 属性值不为 null 的属性
     * */
    default public boolean update(Org org){
        return false;
    }



    @Query("match(n:Org) where n.id={id} return n")
    default public Org findbyId(@Param("id") String id){
        return null;
    }



}
