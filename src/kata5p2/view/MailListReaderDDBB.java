package kata5p2.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderDDBB {

    public static List<Mail> read() throws IOException, ClassNotFoundException, SQLException {
        List<Mail> mailList = new ArrayList<>();

        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:KATA5.db";
        try (Connection connection = DriverManager.getConnection(urlConection); 
                Statement statement = connection.createStatement()) {
            
            String query = "select * from mail";
            try (ResultSet rs = statement.executeQuery(query)) {
                String mail;
                while (rs.next()) {
                    mail = rs.getString("Mail");
                    mailList.add(new Mail(mail));
                }
            }
        }

        return mailList;
    }
}
