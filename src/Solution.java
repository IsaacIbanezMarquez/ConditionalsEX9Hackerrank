import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



// ENUNCIADO:

/*  En un creuament hem d'organitzar tres semàfors: un per vianants, un per tranvia i un per cotxes. El de tranvia és només de {STOP | GO}, mentre que el de vianants i cotxes {VERD | GROC | VERMELL}.

El programa reconeix si nosaltres som vianant, tranvia o cotxe i depenent de com entrem l'estat dels semàfors ens ha d'indicar si podem avançar o ens hem d'aturar, només quan sigui {GO | VERD}.

S'ha de vigilar amb les col·lisions! En cas de possible col·lisió, només quan tenim dos semàfors en {VERD | GO} al mateix moment, s'escriu el missatge: "POSSIBLE COLISIO".

Input Format

Introduïm en un String que som {VIANANT | COTXE | TRANVIA} Introduïm un String per l'estat del semàfor del tranvia. Introduïm un String per l'estat del semàfor dels vianants. Introduïm un String per l'estat del semàfor del cotxes.

Constraints

Vigilar amb les col·lisions.

Output Format

Escriurem si podem avançar o ens hem d'aturar {ENDAVANT | PARAR}

Però en cas de col·lisió, aquesta preval i per tant cal escriure el missatge d'error: "POSSIBLE COLISIO".

Sample Input 0

TRANVIA
GO
VERD
GROC
Sample Output 0

POSSIBLE COLISIO
Sample Input 1

TRANVIA
GO
VERMELL
GROC
Sample Output 1

ENDAVANT
Sample Input 2

VIANANT
GO
VERD
VERMELL
Sample Output 2

POSSIBLE COLISIO
Sample Input 3

VIANANT
STOP
VERD
VERMELL
Sample Output 3

ENDAVANT
Sample Input 4

VIANANT
STOP
GROC
VERMELL
Sample Output 4

PARAR

 */







public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String queSoy = sc.nextLine();
        String Tranvia = sc.nextLine();
        String Peaton = sc.nextLine();
        String Coches = sc.nextLine();

        if (queSoy.equals("TRANVIA"))
        {
            if (Tranvia.equals("GO") && (Coches.equals("VERD")  || Tranvia.equals("GO") && Peaton.equals("VERD"))){System.out.println("POSSIBLE COLISIO");}
            if (Tranvia.equals("GO") && (Coches.equals("VERMELL") || Coches.equals("GROC")) && Peaton.equals("VERMELL") || Peaton.equals("GROC")){System.out.println("ENDAVANT");}

            if (Tranvia.equals("STOP") ){System.out.println("PARAR");}
        }

        if (queSoy.equals("VIANANT") )
        {
            if ( Peaton.equals("VERD") && (Tranvia.equals("GO") || Peaton.equals("VERD") && Coches.equals("VERD"))){System.out.println("POSSIBLE COLISIO");}
            if (Peaton.equals("VERD") && (Tranvia.equals("STOP") && (Coches.equals ("VERMELL") || Coches.equals("GROC")))) {System.out.println("ENDAVANT");}
            if (Peaton.equals("GROC")){System.out.println("PARAR");}
            if (Peaton.equals("VERMELL")) {System.out.println("PARAR");}
        }

        if (queSoy.equals("COTXE"))
        {
            if ( Coches.equals("VERD") && (Tranvia.equals("GO") && Coches.equals("VERD") || Peaton.equals("VERD"))) {System.out.println("POSSIBLE COLISIO");}
            if ( Coches.equals("VERD") && Tranvia.equals("STOP") && Coches.equals("VERD") && Peaton.equals("VERMELL")) {System.out.println("ENDAVANT");}
            if ( Coches.equals("VERD") && Tranvia.equals("STOP") && Peaton.equals("GROC")) {System.out.println("ENDAVANT");}

            if ( Coches.equals("VERMELL") || Coches.equals("GROC") ){System.out.println("PARAR");}

        }

    }

}
