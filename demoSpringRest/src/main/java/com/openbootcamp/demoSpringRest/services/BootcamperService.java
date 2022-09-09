package com.openbootcamp.demoSpringRest.services;


import com.openbootcamp.demoSpringRest.models.Bootcamper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

@Service
public class BootcamperService {
    private final List<Bootcamper> bootcampers = new ArrayList<>();

    public List<Bootcamper> getAll() { return bootcampers; }

    public void add(Bootcamper bootcamper){ bootcampers.add(bootcamper); }
    public boolean delete(String nombre){
        for (Bootcamper bootcamper:bootcampers){
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
                bootcampers.remove(bootcamper.getNombre());
                return true;
            }
        }
        return false;
    }

    public boolean update(String nombre, String nuevoNombre){
        for (Bootcamper bootcamper:bootcampers){
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
                bootcamper.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    public Bootcamper get(String nombre){
        for (Bootcamper bootcamper: bootcampers){
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)){
                return bootcamper;
            }
        }
        return null;
    }

//    public boolean update(String nombre, String nuevoNombre){
//        for (Bootcamper bootcamper:bootcampers){
//            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
//                bootcamper.setNombre(nuevoNombre);
//                return true;
//            }
//        }
//        return false;
//    }


//    public boolean delete(String nombre){
//        Iterator<Bootcamper> iterator = bootcampers.iterator();
//        while(iterator.hasNext()){
//            Bootcamper bootcamper = iterator.next();
//            if (bootcamper.getNombre().equalsIgnoreCase(nombre)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
//    }



}
