package singleton;

import java.util.Objects;

public class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {

        if (Objects.isNull(instance))
            instance = new ConnectionPool();

        return instance;
    }
}
