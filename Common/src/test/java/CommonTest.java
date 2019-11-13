
import kasei.springcloud.common.JwtUtil;
import kasei.springcloud.common.MessageDigestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CommonTest {

    @BeforeAll
    public static void a(){

    }

    @BeforeEach
    public void b(){

    }


    @Test
    public void run() throws Exception {
        String base64 = MessageDigestUtil.generateMD("KaseiHaku1234");
        System.out.println(base64);

    }

    @Test
    public void test(){


        for(int i=0; i<4; i++){

            System.out.println(JwtUtil.createJWT(null));
        }



    }

}
