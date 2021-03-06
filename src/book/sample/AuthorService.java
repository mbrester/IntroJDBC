/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.sample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brester
 */
public class AuthorService {
    private DaoStrategy daoStrategy;
    private TodaysDateFormated date;
     

    public AuthorService(DaoStrategy daoStrategy) {
        this.daoStrategy = daoStrategy;
        this.date = new TodaysDateFormated();
       
    }
    
    public void deleteRecordByID(Object pkValue ) throws Exception{
        daoStrategy.deleteRecordByID(pkValue);
        
    }
    
    public void createNewAuthoer(String authorName) throws Exception{

        Map<String,Object> record = new HashMap<>();
        record.put("author_name", authorName);
        record.put("date_added", date.getDate());
        daoStrategy.createNewRecord(record);
    }
    
    public void updateRecord(String newAuthorName,int pkValue) throws Exception{
        Map<String,Object> record = new HashMap<>();
        record.put("author_name", newAuthorName);
        record.put("date_added", date.getDate());
        daoStrategy.updateRecord(record,pkValue);
    }
    
    
    
    public List getAllAuthors() throws Exception{
        return daoStrategy.getAllRecords();
    }
   
   public static void main(String[] args) throws Exception {
         AuthorService dao = new AuthorService(new AuthorDaoStrategy(new MySqlDbStrategy(),"com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/book","root","password"));
         
         dao.createNewAuthoer("DUDUU DU DUUUU");
    }
    
    
}
