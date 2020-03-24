/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author School
 */
public class Shell {

    public Shell() {
    }

    public void com() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        int ok = 1;
        while (ok == 1) {
            String comanda;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter command: ");
            comanda = scanner.nextLine();
            /*
             load catalog by command
             */
            if ("load".equals(comanda)) {
                LoadCommand l = new LoadCommand();
                l.executa();
            } /*
             list catalog's documents by command
             */ else if ("list".equals(comanda)) {
                ListCommand l = new ListCommand();
                l.executa();
            } /*
             view by command
             */ else if ("view".equals(comanda)) {
                ViewCommand v = new ViewCommand();
                v.executa();
            } else if ("raport".equals(comanda)) {
                RaportHTML r = new RaportHTML();
                r.executa();
            } /*
             exits
             */ else if ("exit".equals(comanda)) {
                ok = 0;
            } else {
                System.out.println("Comanda invalida!");
            }
        }
    }
}
