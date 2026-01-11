package com.example.camel.camelmicroservicea.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRoutar extends RouteBuilder {

    /*
    Donde creamos todas nuestras rutas
    Escuchamos una cola y cualquier cosa que qeuremos escuchar
    le hacemos una trasformacion y guardarlos en una base de datos

     */
    @Override
    public void configure() throws Exception {
        from("timer:first-timer") //Mi colaa
                .transform().constant("My Costantn Mensaje ")
                .to("log:first-timer");// Dtabase en un log
    }
}
