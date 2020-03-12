package ru.ifmo.se.Commands;


import java.util.Enumeration;
import java.util.Scanner;

import static ru.ifmo.se.Main.TicketsHashTable;


/** Remove all elements in collection with higher key*/
public class RemoveGreaterKey implements Execute {

    @Override
    public void execute(String string, Scanner scan, ExeClass eCla) {
        Enumeration enums = TicketsHashTable.keys();
        while (enums.hasMoreElements()){
            String keyE = (String) enums.nextElement();
            if(string.compareTo(keyE) < 0){
                TicketsHashTable.remove(keyE);
            }
        }
    }
}
