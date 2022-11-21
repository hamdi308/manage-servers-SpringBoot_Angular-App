package com.manageServer.server.Service.implementation;

import com.manageServer.server.Repository.ServerRepository;
import com.manageServer.server.model.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerService implements com.manageServer.server.Service.ServerService {
    final ServerRepository serverRepository;

    @Override
    public Server createServer(Server server) {
        log.info("Saving new server: {}",server.getName());
        server.setImageUrl(setServerImageUrl());
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server ping(String ipAdresse) {
        return null;
    }

    @Override
    public Server getServer(Long id) {
        return null;
    }

    @Override
    public Server updateServer(Server server) {
        return null;
    }

    @Override
    public Boolean deleteServer(Long id) {
        return null;
    }
    private String setServerImageUrl() {
        return null;
    }
}
