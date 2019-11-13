package kasei.springcloud.loginregister.service;

import kasei.springcloud.orgarchstaff.repository.entity.Staff;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterService {

    private final RestTemplate restTemplate;

    public RegisterService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Staff someRestCall(String name) {
        return this.restTemplate.getForObject("/{name}/details", Staff.class, name);
    }

}
