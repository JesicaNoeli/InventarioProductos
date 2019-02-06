/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import javax.swing.JOptionPane;

/**
 *
 * @author Popa
 */
public class Seguridad {
   
    public boolean validarClave(String claves[],String clave, int intentos){
   boolean encontrado = false;
   for(int i = 0; i< claves.length; i++){
   if (claves[i].equals(clave)) {
    encontrado = true; 
    intentos=0;
    break;
   }
}
   if (encontrado == false){
     JOptionPane.showMessageDialog(null, "Clave Incorrecta");  
   }
   if(intentos > 2){
    JOptionPane.showMessageDialog(null, "Usted ingreso 3 veces la clave de manera erronea , el programa se cerrara");   
   System.exit(0);
   }
  return encontrado; 
}
    
}
