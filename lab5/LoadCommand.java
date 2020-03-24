/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 *
 * @author School
 */
public class LoadCommand implements Command {

    public LoadCommand() {
    }

    @Override
    public void executa() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter catalog path: "); //for testing E:\\Fac\\2\\Programare Avansata\\Lab5\\catalog.ser
        String cale = scanner.nextLine();
        Catalog catalog = CatalogUtil.load(cale);
        System.out.println("Loaded catalog");
    }
}
