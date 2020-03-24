/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author School
 */
public class RaportHTML implements Command {
    public RaportHTML() {
    }

    @Override
    public void executa() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        String html="<!DOCTYPE html><html><head><title> Raport HTML </title></head><body><ol> &continut& </ol></body></html>";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter catalog path: "); //for testing E:\\Fac\\2\\Programare Avansata\\Lab5\\catalog.ser
        String cale = scanner.nextLine();
        Catalog catalog = CatalogUtil.load(cale);
        java.util.List<Document> documents = new ArrayList<>();
        documents = catalog.getDocuments();
        StringBuilder sb = new StringBuilder();
        for (Document d : documents) {
            sb.append("<li>").append(d.toString()).append("</li>");
        }
        String fisier = html.replace("&continut&", sb.toString());
        try (FileWriter myWriter = new FileWriter("raport.html")) {
            myWriter.write(fisier);
        }
        System.out.println("Successfully wrote the raport.");
    }
}
