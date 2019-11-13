import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kasei.springcloud.common.MessageDigestUtil;
import kasei.springcloud.loginregister.LoginRegisterApplication;
import kasei.springcloud.loginregister.repository.dao.VerificationMapper;
import kasei.springcloud.loginregister.repository.entity.Verification;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = LoginRegisterApplication.class)
public class LoginRegisterTest {

    @Autowired
    private VerificationMapper verificationMapper;

    @Test
    public void run() throws Exception {
        String base64 = MessageDigestUtil.generateMD("KaseiHaku1234");
        System.out.println(base64);

    }

    @Test
    public void test() throws JsonProcessingException {

        Verification byId = verificationMapper.getById("1223");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(byId);

        System.out.println(json);


    }

}
