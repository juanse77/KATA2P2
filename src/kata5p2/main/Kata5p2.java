package kata5p2.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDDBB;

public class Kata5p2 {

    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;

    public static void main(String[] args) {
        Kata5p2 kata4 = new Kata5p2();
 
        try {
            kata4.execute();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada salida: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error de SQL:" + ex.getMessage());
        }
    }

    public void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }

    public void input() throws IOException, ClassNotFoundException, SQLException {
        mailList = MailListReaderDDBB.read();
    }

    public void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }

}
