package kasei.springcloud.loginregister.repository.dao;

import kasei.springcloud.loginregister.repository.entity.Verification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationMapper {

    public Verification getById(String id);

}
