package org.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    final String url;
    final String username;
    final String password;
    final Connection connection;

    DBService(String url, String username, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }
    void dropAllTables() throws ClassNotFoundException, SQLException {
        String sqlStatement[] =
                {
                        "DROP TABLE IF EXISTS person",
                        "DROP TABLE IF EXISTS residence"
                };
        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables removed");
    }
    void createAllTables() throws SQLException {
        String sqlStatement[]=
                {
                        """
                        CREATE TABLE lab5.residence (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            country varchar(100) NOT NULL,
                            city varchar(100) NOT NULL,
                            address varchar(100) NOT NULL,
                            CONSTRAINT PK_RESIDENCE PRIMARY KEY (id)
                        );
                        """,
                        """
                         CREATE TABLE lab5.person (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            name varchar(100) NOT NULL,
                            surname varchar(100) NOT NULL,
                            dataOfBirth date NOT NULL,
                            id_residence BIGINT, -- Assuming this is the foreign key column
                            CONSTRAINT PK_PERSON PRIMARY KEY (id),
                            FOREIGN KEY (id_residence) REFERENCES lab5.residence(id) ON UPDATE CASCADE ON DELETE SET NULL
                        );
                        """
                };

        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables created");
    }
}