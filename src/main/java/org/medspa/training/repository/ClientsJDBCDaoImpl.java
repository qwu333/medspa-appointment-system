package org.medspa.training.repository;
import  org.medspa.training.model.Clients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ClientsJDBCDaoImpl implements iClientsDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/medspa";
    static final String USER = "Amy";
    static final String PASS = "Awu79613";

    @Override
    public List<Clients> getClients() {
        List<Clients> clients = new ArrayList<Clients>();
        Logger logger = LoggerFactory.getLogger(ClientsJDBCDaoImpl.class);
        logger.debug("Started to getClients from Postgres via JDBC");

        //1. Prepare required data model
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //2. open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //3. execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Clients";
            rs = stmt.executeQuery(sql);
            logger.info("Connected to DB successfully and executed the query.");

            //4.extract data
            while(rs.next()){
                long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int phoneNumber = rs.getInt("phoneNumber");
                String emailAddress = rs.getString("emailAddress");
                String allergies = rs.getString("allergies");
                String targets = rs.getString("targets");


                Clients client = new Clients();
                client.setId(id);
                client.setFirstName(firstName);
                client.setLastName(lastName);
                client.setPhoneNumber(phoneNumber);
                client.setEmailAddress(emailAddress);
                client.setAllergies(allergies);
                client.setTargets(targets);

                clients.add(client);


            }


        }catch (SQLException e){
            logger.error("Unable to connect to DB or execute query", e);
            //e.printStackTrace();
        }finally{
            try{
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            }catch (SQLException e){
                logger.error("Unable to close db connection", e);
                //e.printStackTrace();
            }
        }
        logger.info("finish getClients, %s", clients);
        return clients;
    }
}
