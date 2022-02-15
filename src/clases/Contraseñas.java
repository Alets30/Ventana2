/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class Contraseñas {
    private String alf="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789!#$%&/()=?¡'¿{}-+*", clv;
    private Random obr=new Random();
    private int can, con;
    private Scanner obs=new Scanner(System.in);
    
    
    //Este método es una prueba de la generación de contraseñas en serie.
    public void Prueba(){
        do
        {
            System.out.println("Cuál es la cantidad de claves a generar");
            can=obs.nextInt();
        }
        while(can<0);
        for(con=0;con<can;con++)
        {
            do
                clv=""+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))
                +alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()));
            while(!this.Validar(clv));
            System.out.print(clv+"\t");
            if((con+1)%5==0)
                System.out.println();
        }
    }
    
    //Este método genera la contraseña y valida que cumpla con los 4 carácteres mínimos y la longitud de 8
    //si cumple retorna la contraseña, en caso contrario genera otra.
    public String Generar()
    {
        do
            clv=""+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))
            +alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()))+alf.charAt(obr.nextInt(alf.length()));
        while(!this.Validar(clv));
        return clv;
    }
    
    //Este método valida que la contraseña tenga los 4 carácteres mínimos y la longitud de 8, de ser así
    //retorna un verdadero y en caso contrario retornará un falso.
    public boolean Validar(String clave)
    {
        int may = 0, min = 0, num = 0, ce = 0, c;
        if(clave.length() == 8)
        {
            for(c = 0 ; c < 8; c++)
                if("abcdefghijklmnñopqrstuvwxyz".contains(""+clave.charAt(c)))
                    min++;
                else
                    if("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".contains(""+clave.charAt(c)))
                        may++;
                    else
                        if("0123456789".contains(""+clave.charAt(c)))
                        num++;
                        else
                            if("!#$%&/()=?¡'¿{}-+*".contains(""+clave.charAt(c)))
                            ce++;
            if(min>0 && may>0 && ce>0 && num>0)
                return true;
        }
            return false;
    }
}
