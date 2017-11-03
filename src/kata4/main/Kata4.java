package kata4.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    public static void main(String[] args) {
        String fileName = "emailsfile.txt";

        try {
            List<Mail> mailList = MailListReader.read(fileName);

            Histogram<String> histogram = MailHistogramBuilder.build(mailList);
            HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
            histoDisplay.execute();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de entrada salida");
        }
    }

}
