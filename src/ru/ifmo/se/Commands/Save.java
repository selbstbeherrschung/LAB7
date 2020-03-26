package ru.ifmo.se.Commands;

import ru.ifmo.se.WriteInOut.InFileParser;
import ru.ifmo.se.WriteInOut.Terminal;

import java.io.*;
import java.util.Scanner;

import static ru.ifmo.se.Main.*;


/** This class provides possibility to save collection in file*/
public class Save implements Execute {

    @Override
    public void execute(String string, Scanner scan, ExeClass eCla) {
        if (Terminal.programState[7]){
            File file = Terminal.RWfiles[2];

            File logs = new File("logs.json");
            if(!logs.exists()){
                if(new File(".").canWrite()){
                    try {
                        if(logs.createNewFile()){
                            System.out.println("logs.json created");
                        }
                    }catch (IOException e){
                        System.out.println("logs.json can't be created");
                    }
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(logs)) {
                try (BufferedOutputStream bos = new BufferedOutputStream(outputStream)) {
                    String str = ("{\n\t\"FileName\": \"" + Terminal.RWfiles[2].getAbsolutePath() + "\"\n}");
                    byte[] buffer = str.getBytes();
                    bos.write(buffer, 0, buffer.length);
                }catch (IOException e){
                    System.out.println("There are problems with updating logs.json while writing");
                }
            } catch (IOException e) {
                System.out.println("There are problems with updating logs.json while opening");
            }

            InFileParser IFP = new InFileParser(file);
            IFP.saveInFile();
        }else{
            System.out.println("You choose file in which you can't write");
        }
    }
}
