package com.manageServer.server.Service.implementation;

import com.manageServer.server.Repository.ServerRepository;
import com.manageServer.server.enumeration.Status;
import com.manageServer.server.model.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Random;

import static com.manageServer.server.enumeration.Status.SERVER_DOWN;
import static com.manageServer.server.enumeration.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;

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
        return serverRepository.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server ping(String ipAdresse) throws IOException {
        log.info("pinging server IP: {}",ipAdresse);
        Server server=serverRepository.findByIpAdresse(ipAdresse);
        InetAddress adresse = InetAddress.getByName(ipAdresse);
        server.setStatus(adresse.isReachable(10000)? SERVER_UP:SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Server getServer(Long id) {
        log.info("get server by id {}",id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server updateServer(Server server) {
        log.info("update server: {}",server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean deleteServer(Long id) {
        log.info("delete server by id: {}",id);
        serverRepository.deleteById(id);
        return TRUE;
    }
    private String setServerImageUrl() {
        String[] imagesNames={"server1.png","server2.png","server3.png","server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("server/image/"+imagesNames[new Random().nextInt(4)])
                .toUriString();
    }
}
