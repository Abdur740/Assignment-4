// "1. Design a class for a simple database connection pool. The class should have the following features:
//- A private constructor to prevent the class from being instantiated directly.
//- A static method that returns an instance of the class (following the singleton pattern).
//- A method that returns a new connection to the database.
//-A method that closes all open connections and releases them back to the pool.


package dbconnection;
import java.util.Scanner;
import java.util.logging.Logger;

class dbconnection{
    public static final Logger LOGGER = Logger.getLogger("InfoLogging");
    static dbconnection connection = null;    
    private dbconnection(){
        
    }
    public static dbconnection getInstance(){
        if(connection == null){
            connection = new dbconnection();
        }
        return connection;
    }
    public void newconnection(){
        LOGGER.info("connected at : {}",connection);
    }
    public void closeconnection(){
        connection = null;
        LOGGER.info("connection closed\nSelect option for new connection." );   
    }
}

public class Database{
    public static final Logger LOGGER = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);               
        int loop = 0;
            while (loop==0){
                try{
                dbconnection db = dbconnection.getInstance();
                LOGGER.info("select 1. To start a new connection\nselect 2. To close or get new a connection\nselect 3. To Exit a connection");
                LOGGER.info("Enter choice: ");
                int choice = sc.nextInt();
                    switch(choice){
                        case 1:
                            db.newconnection();
                            break;
                        case 2:
                            db.closeconnection();
                            break;
                        case 3:
                            loop=1;
                            LOGGER.info("Exit.");
                            break;
                        default:
                            LOGGER.info("Please select a valid choice (1/2): ");  
                            break;          
                    }
                }
                catch(Exception e){
                    ;LOGGER.info("{}",e)
                    sc.nextLine();
                }
        }
    }
}
