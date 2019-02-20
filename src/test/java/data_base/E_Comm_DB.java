package data_base;

import basePack.BaseClass;
import org.testng.Assert;

public class E_Comm_DB extends BaseClass {

    String qry_string;

    DB_Columns columns = new DB_Columns();

    public void aspNetUsers(String userName) throws Exception{

        Thread.sleep(5000);
        statement = connection.createStatement();
        qry_string = "SELECT * FROM AspNetUsers WHERE UserName = '"+ userName + "'" ;
        e_comm = statement.executeQuery(qry_string);

        while (e_comm.next()){

//            check for first name
            columns.db_FirstName();

//            check for last name
            columns.db_LastName();

//            Email
            columns.db_Email(userName);

//            Phone number
            columns.db_PhoneNumber();

//            Address Line 1
            columns.db_Address1();

//            City
            columns.db_City();

//            PostalZipCode
            columns.db_PostalZipCode();
        }
    }
}
