package com.liy.cloud.controller;

import com.liy.cloud.enttiy.SystemRole;
import com.liy.cloud.service.SystemRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RequestMapping("/provider/system")
@RestController
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;

    // 声明服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;
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


    /**
     *  获取服务列表中所有的服务名称
     * @return
     */
    @GetMapping("/discovery")
    public Object discoveryClientConfiguration(){

        // 获取所有服务列表中服务名称，即：spring.application.name
        List<String> services = discoveryClient.getServices();
        services.forEach(service ->{
            // 获取指定名称的所有服务提供者
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
            serviceInstances.forEach(serviceInstance -> {
                String host = serviceInstance.getHost();
                URI uri = serviceInstance.getUri();
                String serviceId = serviceInstance.getServiceId();
                int port = serviceInstance.getPort();
                log.info("host[{}],port[{}],uri[{}],serviceId[{}]",host,port,uri,serviceId);
            });
        });
        return services;
    }

}
