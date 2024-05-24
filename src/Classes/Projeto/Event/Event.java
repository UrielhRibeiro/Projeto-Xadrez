package Classes.Projeto.Event;

import Classes.Projeto.ClassFinder.ClassFinder;
import Classes.Projeto.Event.Interface.EventHandler;

import javax.management.JMException;
import javax.management.ObjectName;

import java.lang.management.ManagementFactory;
import java.util.*;

import java.lang.reflect.*;

import static Classes.Projeto.ClassFinder.ClassFinder.*;

public class Event extends ClassLoader {

    //Map que possui o Identificador do evento e todos os metodos que possuem a anotacao
    private static final Map<String, ArrayList<Method>> events = new HashMap<>();

    /*
        Ela vai pegar todos os metodos q possuem a anotacao
        "EventHandler" e vai adicionar ao Map events
    */

    public void ProcessEvents() throws Exception {
        for(var classes : findAllClasses(ClassFinder.directory)){
            var methods = classes.getDeclaredMethods();
            for(Method method: methods){
                method.setAccessible(true);
                if(method.isAnnotationPresent(EventHandler.class)){

                    EventHandler annotation = method.getAnnotation(EventHandler.class);
                    Class<?>[] annotationParameter = annotation.parametersType();
                    Parameter[] methodParameter = method.getParameters();
                    if(annotationParameter.length != methodParameter.length){
                        new Exception(); // adicionar a excessao personalizada dps
                        //essa e relacionada com a quantidade de parametros
                        continue;
                    }
                    for(int i = 0; i < annotationParameter.length; i++){
                        if( annotationParameter[i] != methodParameter[i].getClass() ) {
                            new Exception(); //adicionar a excessao personalizada dps
                            //essa relacionada com o tipo de parametros
                            continue;
                        }
                    }
                    ArrayList<Method> tempList = this.events.get(annotation.name());
                    if(tempList == null){
                        tempList = new ArrayList<>();
                    }
                    tempList.add(method);
                    this.events.put(annotation.name(), tempList);
                }
            }
        }
    }

    //Funcao responsavel pelo acionamento do evento
    //String name: se refere ao nome do evento definido na anotacao
    //Object...args: sao os argumentos referidos aos parametros do metodo dito na Anotacao e no metodo q a possui
    public static void triggerEvent(String name, Object...args) throws Exception {
        ArrayList<Method> methods = events.get(name);
        ArrayList<Class<?>> methodParameters = new ArrayList<>();
        try {

            Class<?>[] eventParameters = methods.getFirst().getParameterTypes();

            for(int i =0; i < args.length; i++){
                try{
                    eventParameters[i] = ClassFinder.findWrapper(eventParameters[i]);
                    assert eventParameters[i] != null;
                    Object obj = eventParameters[i].cast(args[i]);
                }catch (Exception e){

                    System.out.println(e);
                    //parametros de tipos diferentes
                }
            }

            if(eventParameters.length != args.length){
                throw new Exception(); // adicionar a excessao personalizada dps
                //tem mais ou menos parametros no metodo
            }

            for(Method method : methods){
                method.invoke(null, args);
            }

        } catch(Exception e) {
            System.out.println(e);
            // isso aqui so pq o methods.getFirst() pode n existir
        }

    }

//    public static void addEventHandler(String name, IHandler handler){
//
//    }
}















