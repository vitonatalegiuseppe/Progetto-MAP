/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uniba.map.myadventure.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sensei Tequila
 */
public class FileManagement {
    private String filename;
    
    public FileManagement(String filename) {
        this.filename = filename;
    }
    
    public void writeString(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(text);
            System.out.println("String \"" + text + "\" saved successfully to the file " + filename);
        } catch (IOException e) {
            System.err.println("Error while saving the file: " + e.getMessage());
        }
    }
    
    public String[] readString(int dim) throws FileNotFoundException, IOException {
        String[] descElem = new String[76];
        int pos;
        String desc;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Scanner s = null;
            try {
                s = new Scanner(reader);
                s.useDelimiter("\\n");
                while (s.hasNext()) {
                    pos = Integer.parseInt(s.next().trim());
                    desc = s.next();
                    descElem[pos] = desc;
                }
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }
        return descElem;
    }
}