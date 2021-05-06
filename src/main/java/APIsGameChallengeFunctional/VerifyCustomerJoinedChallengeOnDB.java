package APIsGameChallengeFunctional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class VerifyCustomerJoinedChallengeOnDB {
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";
    public static String fname = null;

    public static void verifyCustomerJoinedChallengeOnDB() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        try {
            Connection conn = DriverManager.getConnection(properties.getProperty("localhost_url"));
            {
                if (conn != null) {
                    PreparedStatement pst = conn.prepareStatement(
                            "SELECT * " +
                                    "FROM public.customer_challenge " +
                                    "where customer_id = '84901000100'" +
                                    "AND challenge_id = 'c0a88e43-7718-1c67-8177-198f4f7c0009'");
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            fname = rs.getString("customer_id");
                            System.out.println("The customer_id has joined the challenge is :" + fname);
                        }
                    }
                } else
                    System.out.println("Failed to connect");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
