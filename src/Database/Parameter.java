package Database;

//class yang mendeklarasikan nilai parameter untuk digunakan oleh fungsi koneksi database
public class Parameter {
    public static String IPHOST="127.0.0.1";
    public static String HOST_DB="jdbc:mysql://"+IPHOST+":3306/rental_mobil";
    public static String USERNAME_DB="root";
    public static String PASSWORD_DB="";
    public static int PORT=11111;
    public static String USER;
}