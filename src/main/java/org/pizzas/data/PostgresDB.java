package org.pizzas.data;

import java.sql.Connection;
import java.sql.DriverManager;
import org.pizzas.data.interfaces.IDB;


public class PostgresDB implements IDB {


    private static volatile PostgresDB instance;
    private PostgresDB(){

    }

    public static PostgresDB getInstance() {
        if (instance == null) {
            synchronized (PostgresDB.class) {
                if (instance == null) {
                    instance = new PostgresDB();
                }
            }
        }
        return instance;
    }
    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "2502");
            return con;
        } catch (Exception e) {
            System.out.println("failed to connect to postgres: " + e.getMessage());
            return null;
        }
    }
}