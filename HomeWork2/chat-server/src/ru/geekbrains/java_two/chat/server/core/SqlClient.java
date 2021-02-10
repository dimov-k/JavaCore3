package ru.geekbrains.java_two.chat.server.core;

import org.sqlite.JDBC;

import java.sql.*;

public class SqlClient {

    private static SqlClient instance;
    private static Connection connection;
    private static Statement statement;

    private SqlClient(){}
    public static SqlClient getInstance() {
        if(instance == null) {
            instance = new SqlClient();
        }
        return instance;
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(JDBC.PREFIX + "chat-server/clients.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNickname(String login, String password) {
        // select nickname from clients where login='dimov.k' and password='123'
        String query = String.format("select nickname from clients where login='%s' and password='%s'",
                login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next()) {
                return set.getString("nickname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static int changeNickname (String new_nickname, String old_nickname  ) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(" UPDATE clients SET nickname = ? WHERE nickname = ?");
        ps.setString(1,new_nickname);
        ps.setString(2,old_nickname);
        int ep = ps.executeUpdate();
        return ep;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
