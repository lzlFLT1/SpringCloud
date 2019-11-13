package kasei.springcloud.loginregister.repository.entity;


import org.apache.ibatis.type.Alias;

@Alias("Verification")
public class Verification {

    private String id;
    private String account;
    private String type;
    private String certificate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
