package com.example.la_biblioteca_final;

import com.mail.MailTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class LaBibliotecaFinalApplication {



    public static void main(String[] args) {

        SpringApplication.run(LaBibliotecaFinalApplication.class, args);

//        MailTypes mt = new MailTypes();

//
//
//        List ls = new ArrayList();
//        ls.add(-4);
//

//        mt.reaction(2,"תודה רבה! נשמח שתגרד אותנו בערוצים המובילים בטלגרם בניהם WEBUTNET, בנוסף ");
    }

}
