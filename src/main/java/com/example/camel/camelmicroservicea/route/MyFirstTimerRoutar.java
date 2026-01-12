package com.example.camel.camelmicroservicea.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MyFirstTimerRoutar extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;
    /*
    Donde creamos todas nuestras rutas
    Escuchamos una cola y cualquier cosa que qeuremos escuchar
    le hacemos una trasformacion y guardarlos en una base de datos
     */
    @Override
    public void configure() throws Exception {
        from("timer:first-timer") //Mi colaa
                //.transform().constant("My Costantn Mensaje ")
                //.transform().constant("El tiempo Ahora" + LocalDateTime.now())
                // dinamica
                .bean(getCurrentTimeBean)
                .to("log:first-timer");// Dtabase en un log
    }
}

@Component
class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "El tiempo Ahora" + LocalDateTime.now();
    }
}