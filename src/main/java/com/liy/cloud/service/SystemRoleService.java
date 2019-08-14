package com.liy.cloud.service;

import com.liy.cloud.enttiy.SystemRole;

import java.util.List;

public interface SystemRoleService {

    public SystemRole saveObject(SystemRole systemRole);

    public void removeObject(SystemRole systemRole);

    SystemRole modifyObject(SystemRole systemRole);

    SystemRole getSystemRoleById(Long id);

    List<SystemRole> getSystemRoleList();

    public boolean removeObjectById(Long id);
}
