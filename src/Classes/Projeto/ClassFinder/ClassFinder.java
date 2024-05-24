package Classes.Projeto.ClassFinder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ClassFinder {
    public static final String directory = System.getProperty("user.dir") +"\\bin";

    public static Class<?> findWrapper(Class clazz){
        String name = clazz.getName();
        if(Objects.equals(name, "boolean")){
            return Boolean.class;

        } else if (Objects.equals(name, "byte")) {
            return Byte.class;

        } else if (Objects.equals(name, "char")) {
            return Character.class;

        } else if (Objects.equals(name, "double")) {
            return Double.class;

        } else if (Objects.equals(name, "float")) {
            return Float.class;

        } else if (Objects.equals(name, "int")) {
            return Integer.class;

        } else if (Objects.equals(name, "long")) {
            return Long.class;

        } else if (Objects.equals(name, "short")) {
            return Short.class;

        }
        return clazz;
    }

    public static List<Class<?>> findAllClasses(String dir) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for(var file : listOfFiles){
            if(file.isDirectory()){
                // ele vai adicionar a lista o que ele encontrar dentro dos diretorios ate entao sem arquivos ".class"
                classes.addAll(findAllClasses(file.toString()));

            } else if(file.toString().contains(".class")) {
                //isso e o diretorio mas no tipo url
                URL[] urls = { file.toURI().toURL() };

                //peguei o tipo url para pegar a classe pelo diretorio
                try (URLClassLoader classLoader = new URLClassLoader(urls)) {

                    Class<?> clazz = classLoader.loadClass(
                            file.toString()
                            .substring(directory.length()+1, file.toString().length() -6)
                            .replaceAll("\\\\",".")
                    );

                    classes.add(clazz);

                }catch(ClassNotFoundException ignored) {}
            }
        }
        return classes;
    }
}
