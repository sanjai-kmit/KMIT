package data_base;

import basePack.BaseClass;
import org.testng.Assert;

public class DB_Columns extends BaseClass {

    public void db_FirstName(){
        try {
            Assert.assertEquals(e_comm.getString("FirstName"), property.getString("firstName"));
            log.info("Data Base: Table - AspNetUsers - FirstName - " + e_comm.getString("FirstName"));
        } catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - FirstName - " + t);
        }
    }

    public void db_LastName(){
        try {
            Assert.assertEquals(e_comm.getString("LastName"), property.getString("lastName"));
            log.info("Data Base: Table - AspNetUsers - LastName - " + e_comm.getString("LastName"));
        } catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - LastName - " + t);
        }
    }

    public void db_Email(String userName){
        try {
            Assert.assertEquals(e_comm.getString("Email"), userName);
            log.info("Data Base: Table - AspNetUsers - Email - " + e_comm.getString("Email"));
        } catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - Email - " + t);
        }
    }

    public void db_PhoneNumber(){
        try {
            Assert.assertEquals(e_comm.getString("PhoneNumber"), property.getString("phoneNumber"));
            log.info("Data Base: Table - AspNetUsers - PhoneNumber - " + e_comm.getString("PhoneNumber"));
        } catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - PhoneNumber - " + t);
        }
    }

    public void db_Address1(){
        try {
            Assert.assertEquals(e_comm.getString("Address1"), property.getString("addressLine_1"));
            log.info("Data Base: Table - AspNetUsers - Address1 - " + e_comm.getString("Address1"));
        }catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - Address1 - " + t);
        }
    }

    public void db_City(){
        try {
            Assert.assertEquals(e_comm.getString("City"), property.getString("city"));
            log.info("Data Base: Table - AspNetUsers - City - " + e_comm.getString("City"));
        }catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - City - " + t);
        }
    }

    public void db_PostalZipCode(){
        try {
            Assert.assertEquals(e_comm.getString("PostalZipCode"), property.getString("zipcode"));
            log.info("Data Base: Table - AspNetUsers - PostalZipCode - " + e_comm.getString("PostalZipCode"));
        }catch (Throwable t){
            log.error("Data Base: Table - AspNetUsers - PostalZipCode - " + t);
        }
    }
}
