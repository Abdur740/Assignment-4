package dbconnection;

import java.util.logging.Logger;

class Dbconnection{
    static int status = 0;
    
    public static final Logger LOGGER = Logger.getLogger("InfoLogging");
    static Dbconnection connection = null;    
    static Dbconnection getInstance(){
        if(connection == null){
            connection = new Dbconnection();
        }
        return connection;
    }
    public static void newconnection(){
        status = 1;
        String print = "Connected to port: "+connection;
        LOGGER.info(print);
    }
    public static void  closeconnection(){
        connection=null;
        status=0;
        String print ="connection closed\nSelect option for new connection.";
        LOGGER.info(print);   
    }
    public static void checkconnection(){
        if(status == 0){
            LOGGER.info("No connection");
        }
        else{
            String print = "Connected at "+connection;
            LOGGER.info(print);
        }
        
}
}

