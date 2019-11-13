package kasei.springcloud.orgarchstaff.repository.entity;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity("Org")
public class Org extends Domain{

    private String orgCode;
    private String orgName;


    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
