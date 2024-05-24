package Classes.Projeto.Event.Interface;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

//anotacoes que definem o Evento
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventHandler {

    String name(); // o nome da chave no map

    Class[] parametersType() default {}; //os parametros q os metodos dos eventos irao possuir

}
