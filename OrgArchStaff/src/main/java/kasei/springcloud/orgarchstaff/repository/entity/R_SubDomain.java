package kasei.springcloud.orgarchstaff.repository.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;

@RelationshipEntity(type="R_SUB_DOMAIN")
public class R_SubDomain {
    @StartNode
    private Domain startNode;

    @EndNode
    private Domain endNode;

    @DateString
    private Date createTime;
}
