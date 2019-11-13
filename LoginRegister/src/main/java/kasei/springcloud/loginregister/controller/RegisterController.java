package kasei.springcloud.loginregister.controller;

import kasei.springcloud.common.UniversalResponse;
import kasei.springcloud.loginregister.repository.dao.VerificationMapper;
import kasei.springcloud.loginregister.repository.entity.Verification;
import kasei.springcloud.loginregister.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired private VerificationMapper verificationMapper;

    @PostMapping("")
    public UniversalResponse register(@RequestParam String account){



        return new UniversalResponse();
    }

    @PostMapping("/verification")
    public Verification verification(@RequestParam String id){

        Verification byId = verificationMapper.getById(id);

        return byId;
    }

}
