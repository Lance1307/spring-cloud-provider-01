package com.liy.cloud.service.impl;

import com.liy.cloud.enttiy.SystemRole;
import com.liy.cloud.repostitory.SystemRoleRepository;
import com.liy.cloud.service.SystemRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private SystemRoleRepository roleRepository;
    @Override
    public SystemRole saveObject(SystemRole systemRole) {
        SystemRole role =  roleRepository.save(systemRole);
        if(role != null) return role;
        return null;
    }

    @Override
    public void removeObject(SystemRole systemRole) {
        roleRepository.delete(systemRole);
    }
    @Override
    public boolean removeObjectById(Long id) {
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public SystemRole modifyObject(SystemRole systemRole) {
        return roleRepository.updateSystemRole(systemRole);
    }

    @Override
    public SystemRole getSystemRoleById(Long id) {

        return roleRepository.findSystemRoleById(id);
    }

    @Override
    public List<SystemRole> getSystemRoleList() {
        return roleRepository.findAll();
    }
}
