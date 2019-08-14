package com.liy.cloud.repostitory;

import com.liy.cloud.enttiy.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemRoleRepository extends JpaRepository<SystemRole,Long> {

    public SystemRole updateSystemRole(SystemRole systemRole);

    public SystemRole findSystemRoleById(Long id);
}
