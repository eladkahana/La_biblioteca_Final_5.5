package com.mail;



import javax.persistence.ParameterMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.io.Reader;
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

            Email email = new Email((String) item[1], "תזכורת להחזרת ספר", content.toString(), (byte[]) item[4]);
            email.SendEmail();
        }


    }

    public void reaction(int ReaderID, String answer) {
        //Email mail = new Email();

//        ReadersController rc = new ReadersController();
//        Readers reader = new Readers();
//        reader = rc.getById(ReaderID);
//        String email = reader.getEmail();

    }
}
