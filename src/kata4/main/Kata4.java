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

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;

    public Kata4(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        Kata4 kata4 = new Kata4("emailsfile.txt");
 
        try {
            kata4.execute();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada salida: " + e.getMessage());
        }
    }

    public void execute() throws IOException {
        input();
        process();
        output();
    }

    public void input() throws IOException {
        mailList = MailListReader.read(fileName);
    }

    public void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }

}
