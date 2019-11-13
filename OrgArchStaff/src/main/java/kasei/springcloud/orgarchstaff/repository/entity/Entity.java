package kasei.springcloud.orgarchstaff.repository.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.Date;

public abstract class Entity {
    @Id // 表示使用自定义的 id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;
    @DateString  // 表示将 java 的 Date 类型转成 String 存到 neo4j 中
    private Date createTime;
    @DateString
    private Date modifyTime;


    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
