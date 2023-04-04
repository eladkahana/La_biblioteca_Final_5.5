package comMain;

import com.fasterxml.jackson.core.JsonProcessingException;
import comMain.mail.MailTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Printable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




@SpringBootApplication
public class LaBibliotecaFinalApplication {



    public static void main(String[] args) throws SQLException, JsonProcessingException {

        SpringApplication.run(LaBibliotecaFinalApplication.class, args);
        MailTypes mt = new MailTypes();
//
//
//
        List ls = new ArrayList();
        ls.add(-67);
        mt.changeDays(ls);
//
        mt.reminder();




        //mt.reaction(2,"תודה רבה! נשמח שתגרד אותנו בערוצים המובילים בטלגרם בניהם WEBUTNET, בנוסף ");
    }

}
