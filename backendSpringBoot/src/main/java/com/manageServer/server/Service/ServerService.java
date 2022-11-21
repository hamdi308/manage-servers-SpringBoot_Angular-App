package com.manageServer.server.Service;

import com.manageServer.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {
    Server createServer(Server server);
    Collection<Server> list(int limit);
    Server ping(String ipAdresse) throws IOException;
    Server getServer(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
}
