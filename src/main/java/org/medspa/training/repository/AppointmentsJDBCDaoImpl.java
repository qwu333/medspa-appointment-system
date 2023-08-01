package org.medspa.training.repository;
import org.medspa.training.model.Appointments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsJDBCDaoImpl implements iAppointmentsDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/medspa";
    static final String USER = "Amy";
    static final String PASS = "Awu79613";

    @Override
    public void save(Appointments appointments) {

    }

    @Override
    public List<Appointments> getAppointments(){
        List<Appointments> appointments = new ArrayList<>();
        Logger logger = LoggerFactory.getLogger(AppointmentsJDBCDaoImpl.class);
        logger.debug("starting to getAppointments from DB");

        //1. set data model
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            //1. open connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            logger.info("connected to DB successfully");

            //2.execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * TABLE Appointments";
            rs = stmt.executeQuery(sql);
            logger.info("Query has been successfully executed");

            //3.extract data

            while(rs.next()){
                long id = rs.getLong("id");
                long client = rs.getLong("client");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                long treatment = rs.getLong("treatment");


                Appointments appointment = new Appointments();
                appointment.setId(id);
                appointment.getClient(client);
                appointment.setDate(date);
                appointment.setTime(time);
                appointment.getTreatment(treatment);
                appointments.add(appointment);

            }
        }catch (SQLException e){
            logger.error("Query execution or DB connection unsuccessful",e);
        }finally{
            try{
                if(conn != null) conn.close();
                if(stmt != null) stmt.close();
                if(rs != null) rs.close();
            }catch (SQLException e){
                logger.error("unable to close query",e);
            }
        }
        logger.info("getAppointments from DB to JDBC through Postgres successful");
        return appointments;
    }

    @Override
    public Appointments getById(Long id) {
        return null;
    }


    @Override
    public boolean delete(Appointments appointments) {

        return false;
    }

    @Override
    public Appointments update(Appointments appointments) {
        return null;
    }




}
