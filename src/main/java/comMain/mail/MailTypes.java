package comMain.mail;



//import com.DTOs.ReadersDTO;
//import com.controllers.ReadersController;
//import com.entities.Readers;
//import com.repositories.ReadersRepository;
//import com.services.ReadersService;

import comMain.controllers.ReadersController;
import comMain.entities.ReadersEntity;
import comMain.repositories.ReadersRepository;
import comMain.services.ReadersService;
import org.springframework.stereotype.Component;

import javax.persistence.ParameterMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class MailTypes {

    private String DaysInString;

    public void changeDays(List<Object> newDays) {
        this.DaysInString = "";
        for (Object day : newDays) {
            this.DaysInString += day.toString();
            this.DaysInString += ",";
        }


    }

    public void reminder() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        StoredProcedureQuery sp = em.createStoredProcedureQuery("dbo.reservedaysleft");
        sp.registerStoredProcedureParameter("arrStr", String.class, ParameterMode.IN);
        sp.setParameter("arrStr", this.DaysInString);
        sp.execute();


        List<Object[]> ls = sp.getResultList();

        for (Object[] item : ls) {
            StringBuilder content = new StringBuilder();
            content.append("שלום ").append(item[0]).append(".<br>");
            if ((int) item[2] >= 0) {
                content.append("רצינו להזכיר לך שבעוד ")
                        .append(item[2])
                        .append(" ימים תצטרך להחזיר את הספר '")
                        .append(item[3])
                        .append("'");
            } else {
                content.append("רצינו להזכיר לך שאתה צריך להחזיר את הספר '")
                        .append(item[3])
                        .append("'");
            }
            content.append("<br> תודה רבה ויום טוב!<br>");
            content.append("<br> ספריית - La Biblioteca<br>");

            Email email = new Email((String) item[1], "תזכורת להחזרת ספר", content.toString());
            email.setImage((byte[]) item[4]);
            email.SendEmail();
        }


    }

    public void reaction(int ReaderID, String answer) {



//        ReadersService rs = new ReadersService();
//        ReadersEntity reader = rs.getById(ReaderID);
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
//        EntityManager em = emf.createEntityManager();
//        StoredProcedureQuery sp = em.createStoredProcedureQuery("dbo.addRespone");
//        sp.registerStoredProcedureParameter("requestID", Integer.class, ParameterMode.IN);
//        sp.registerStoredProcedureParameter("content", String.class, ParameterMode.IN);
//        sp.setParameter("requestID", ReaderID);
//        sp.setParameter("content", answer);
//        sp.execute();
//
//        Email email = new Email(reader.getEmail(),"מענה לפנייתך - מערכת ספרייה",answer);
//        email.SendEmail();


    }
}
