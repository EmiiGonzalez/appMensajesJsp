
package com.app.mensajes;

import java.util.List;


public class Main {
        public static void main(String[] args) throws ClassNotFoundException {
           
            MensajeDao mensajeDao = new MensajeDao();

            //crear
            //Mensaje msm= new Mensaje("Hola", "Juan");
            //int reg = mensajeDao.insertar(msm);
            //System.out.println("Se inserto: " + reg + " registros");

            //editar
            //Mensaje men = new Mensaje("Editado desde main", 1 , "Emi");
            //int reg = mensajeDao.editar(men);
            //System.out.println("Se edito: " + reg + " registros");
            
            //borrar
            Mensaje men = new Mensaje( 1);
            int reg = mensajeDao.eliminar(men);
            System.out.println("Se eliminaron: " + reg + " registros");

            //leer
            List<Mensaje> mensajes = mensajeDao.seleccionar();
            
            for (Mensaje mensaje : mensajes) {
                System.out.println(mensaje);
                
            }
    }
}
