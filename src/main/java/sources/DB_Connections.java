package sources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connections {

    public static ResultSet e_comm;
    public static Connection connection;
    public static Statement statement;

    public void e_comm_connection(String server, String port, String db_name, String userName, String password) throws Exception{

        String url = "jdbc:sqlserver://"+ server + ":" + port + ";databaseName=" + db_name;
/*        String userName = "sa";
        String password = "kmit123$";*/
        String db_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        Class.forName(db_driver);

        connection = DriverManager.getConnection(url, userName, password);
        System.out.println("DB Connected");

//        statement = connection.createStatement();
//        String queryString = "select * from AspNetUsers where UserName = 'sanjaim@kmitsolutions.com'";

//        e_comm = statement.executeQuery(queryString);
//        while (e_comm.next()){
//            System.out.println(e_comm.getString("FirstName") + " " + e_comm.getString("LastName") + " - " + e_comm.getString("CustomerCode"));
//        }


    }
}
