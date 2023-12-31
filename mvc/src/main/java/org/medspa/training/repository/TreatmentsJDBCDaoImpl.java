package org.medspa.training.repository;
import org.medspa.training.model.Treatments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class TreatmentsJDBCDaoImpl implements iTreatmentsDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5431/medspa";
    static final String USER = "Amy";
    static final String PASS = "Awu79613";


    @Override
    public void save(Treatments treatments) {
    }

    @Override
    public List<Treatments> getTreatments() {
        List<Treatments> treatments = new ArrayList<Treatments>();
        Logger logger = LoggerFactory.getLogger(TreatmentsJDBCDaoImpl.class);
        logger.debug("Started to getTreatments from Postgres to JDBC");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

       try{
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           String sql;
           sql = "SELECT * FROM Treatments";
           stmt = conn.createStatement();
           rs = stmt.executeQuery(sql);
           logger.info("connected to DB successfully and executed query");

           while(rs.next()) {
               long id = rs.getLong("id");
               String treatmentName = rs.getString("treatmentName");
               BigDecimal cost = rs.getBigDecimal("cost");
               BigDecimal price = rs.getBigDecimal("price");
               int length = rs.getInt("length");
               String target = rs.getString("target");
               String nurses = rs.getString("nurses");

               Treatments treatment = new Treatments();
               treatment.setId(id);
               treatment.setTreatmentName(treatmentName);
               treatment.setCost(cost);
               treatment.setPrice(price);
               treatment.setLength(length);
               treatment.setTarget(target);
               treatment.setNurses(nurses);
               treatments.add(treatment);
           }

        }catch (SQLException e){
           logger.error("Unable to connect to DB or execute query",e);
       }finally {
           try{
               if (stmt != null) stmt.close();
               if (conn != null) conn.close();
               if (rs != null) rs.close();
           }catch(SQLException e){
               logger.error("unable to close",e);
           }
       }
       logger.info("successful data extraction to Treatments");
       return treatments;
    }

    @Override
    public Treatments getByTreatmentName(String treatmentName) {
        return null;
    }

    @Override
    public boolean delete(Treatments treatments) {
        return false;
    }

    @Override
    public Treatments update(Treatments treatments) {
        return null;
    }

    @Override
    public Treatments getTreatmentsEagerBy(Long id) {
        return null;
    }
}
