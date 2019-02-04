package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import java.util.logging.SimpleFormatter;

public class CDApiLogger {

    static private boolean status;
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private class MyHtmlFormatter extends Formatter {

        // this method is called for every log records
        @Override
        public String format(LogRecord rec) {
            StringBuilder buf = new StringBuilder(1000);
            buf.append("<tr>\n");

            // colorize any levels >= WARNING in red
            if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
                buf.append("\t<td style=\"color:red\">");
                buf.append("<b>");
                buf.append(rec.getLevel());
                buf.append("</b>");
            } else {
                buf.append("\t<td>");
                buf.append(rec.getLevel());
            }

            buf.append("</td>\n");
            buf.append("\t<td>");
            buf.append(calcDate(rec.getMillis()));
            buf.append("</td>\n");
            buf.append("\t<td>");
            buf.append(formatMessage(rec));
            buf.append("</td>\n");
            buf.append("</tr>\n");

            return buf.toString();
        }

        private String calcDate(long millisecs) {
            SimpleDateFormat date_format = new SimpleDateFormat("MMMM dd,yyyy HH:mm");
            Date resultdate = new Date(millisecs);
            return date_format.format(resultdate);
        }

        // this method is called just after the handler using this
        // formatter is created
        @Override
        public String getHead(Handler h) {
            return "<!DOCTYPE html>\n<head>\n<style>\n"
                    + "table { width: 100% }\n"
                    + "th { font:bold 10pt Tahoma; }\n"
                    + "td { font:normal 10pt Tahoma; }\n"
                    + "h1 {font:normal 11pt Tahoma;}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>" + (new Date()) + "</h1>\n"
                    + "<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\">\n"
                    + "<tr align=\"center\">\n"
                    + "\t<th style=\"width:10%\">Nível</th>\n"
                    + "\t<th style=\"width:15%\">Tempo</th>\n"
                    + "\t<th style=\"width:40%\">Messagem</th>\n"
                    + "</tr>\n";
        }

        // this method is called just after the handler using this
        // formatter is closed
        @Override
        public String getTail(Handler h) {
            return "</table>\n</body>\n</html>";
        }
    }

    public void setup() {
//            Logger rootLogger = Logger.getLogger("");
//            Handler[] handlers = rootLogger.getHandlers();
//            if (handlers[0] instanceof ConsoleHandler) {
//                rootLogger.removeHandler(handlers[0]);
//            }
        try {
        LOGGER.setLevel(Level.INFO);
        fileTxt = new FileHandler("ErrorReport.txt", true);
        fileHTML = new FileHandler("ErrorReport.html", true);
        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        LOGGER.addHandler(fileTxt);
        // create an HTML formatter
        formatterHTML = new MyHtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        LOGGER.addHandler(fileHTML);            
        } catch (IOException | SecurityException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void severe(String classe, String method, String msg) {
        LOGGER.log(Level.SEVERE, "Classe: \"{0}\" | Método: \"{1}\" | Mensagem: \"{2}\"", new Object[]{classe, method, msg});
    }

    public void warning(String classe, String method, String msg) {
        LOGGER.log(Level.WARNING, "Classe: \"{0}\" | Método: \"{1}\" | Mensagem: \"{2}\"", new Object[]{classe, method, msg});
    }

    public void fine(String msg) {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(msg);
    }
}
