package kasei.springcloud.orgarchstaff.controller;

import kasei.springcloud.orgarchstaff.repository.dao.StaffDao;
import kasei.springcloud.orgarchstaff.repository.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Staff")
public class StaffController {

    @Autowired private StaffDao staffDao;

    @GetMapping(value="/{id}")
    public Staff getById(@PathVariable String id){
        return staffDao.getById(id);
    }


}
