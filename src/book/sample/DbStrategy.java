/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.sample;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brester
 */
public interface DbStrategy {

    void closeConnection() throws SQLException;

    List<Map<String, Object>> findAllRecords(String tableName) throws SQLException;

    void openConnection(String driverClass, String url, String userName, String password) throws Exception;
    
    void deleteRecord(String tableName, String pkName, Object pkValue) throws SQLException;
    
    public void createNewRecord(Map<String,Object> record, String tableName) throws Exception;
    
     public void updateRecord(Map<String, Object> record, String tableName, String pkName, Object pkValue) throws SQLException;
    
}
