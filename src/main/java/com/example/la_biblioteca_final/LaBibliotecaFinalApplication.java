package com.example.la_biblioteca_final;

import com.mail.MailTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LaBibliotecaFinalApplication {

    public static void main(String[] args) {

        //SpringApplication.run(LaBibliotecaFinalApplication.class, args);

        MailTypes mt = new MailTypes();
        //mt.reminder();


        List ls = new ArrayList();
        ls.add(-4);

        mt.changeDays(ls);
        mt.reminder();
    }

}
