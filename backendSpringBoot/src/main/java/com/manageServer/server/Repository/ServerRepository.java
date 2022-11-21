package com.manageServer.server.Repository;

import com.manageServer.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {
    Server findByIpAdresse(String ipAdresse);
}
