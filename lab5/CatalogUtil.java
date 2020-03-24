/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 * @author School
 */
public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(catalog.getPath()))) {
//            oos.writeObject(catalog);
//        }
        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arr);
        oos.writeObject(catalog);
        oos.close();
        FileWriter scrie = new FileWriter(catalog.getPath());
        scrie.write(Base64.getEncoder().encodeToString(arr.toByteArray()));
        scrie.close();
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String continut = reader.readLine();
        byte[] data = Base64.getDecoder().decode(continut);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Object o = ois.readObject();
            return (Catalog) o;
        } catch (IOException ex) {
            System.out.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }

//        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(path))) {
//            Catalog obj = (Catalog)objectIn.readObject();
//            return obj;
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        } catch (IOException ex) {
//            System.out.println("IOException");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Class not found");
//        }
        return null;
    }

    public static void view(Document doc) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        if (doc.getLocation().contains("https://")) {
            desktop.browse(new URL(doc.getLocation()).toURI());
        } else {
            desktop.open(Paths.get(doc.getLocation()).toFile());
        }
    }
}
