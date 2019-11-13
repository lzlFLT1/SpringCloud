package kasei.springcloud.orgarchstaff.repository.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.Date;
import java.util.Set;

@NodeEntity("Domain") // 表示当前类是 neo4j 节点 model 类
public class Domain extends Entity {

    private String domainName;


    @Relationship(type="R_SUB_DOMAIN", direction = Relationship.INCOMING)
    Set<Domain> subDomains;




    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }



    public Set<Domain> getSubDomains() {
        return subDomains;
    }

    public void setSubDomains(Set<Domain> subDomains) {
        this.subDomains = subDomains;
    }
}
