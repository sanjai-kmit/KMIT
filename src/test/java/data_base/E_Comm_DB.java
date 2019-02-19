package data_base;

import basePack.BaseClass;

public class E_Comm_DB extends BaseClass {

    public void aspNetUsers(String userName) throws Exception{

        Thread.sleep(5000);
        statement = connection.createStatement();
        String qry_string = "SELECT * FROM AspNetUsers WHERE UserName = '"+ userName + "'" ;
        System.out.println("---> DB_UserName: " + userName);
        e_comm = statement.executeQuery(qry_string);

        while (e_comm.next()){
            String act_first_name = e_comm.getString("Firstname");
            String exp_first_name = property.getString("firstName");
            System.out.println("act_first_name: " + act_first_name);
            System.out.println("exp_first_name: " + exp_first_name);

        }
    }
}
