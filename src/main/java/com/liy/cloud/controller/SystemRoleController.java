package com.liy.cloud.controller;

import com.liy.cloud.enttiy.SystemRole;
import com.liy.cloud.service.SystemRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/provider/system")
@RestController
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;

    @PostMapping("/save")
    public SystemRole saveObject(@RequestBody SystemRole role){
        return systemRoleService.saveObject(role);
    }

    @PostMapping("/findById/{id}")
    public SystemRole getSystemRoleById(@RequestParam("id") Long id){
        return systemRoleService.getSystemRoleById(id);
    }
    @PostMapping("/getAll")
    public List<SystemRole> getAll(){
        return systemRoleService.getSystemRoleList();
    }

}
