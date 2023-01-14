package Metier;

import Metier.IMetier;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>, Serializable {

    List <Produit> listProduit = new ArrayList();

    @Override
    public void add(Produit o) {
        listProduit.add(o);
    }

    @Override
    public List<Produit> getAll() {

        try {
            File file = new File("produits.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInput ois = new ObjectInputStream(fis);

            List<Produit> produitList = (List<Produit>)ois.readObject();

            return produitList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveAll(){
        try {
            File file = new File("produits.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(listProduit);

            oos.close();
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Produit findById(long id) {
        for (Produit p:listProduit) {
            if (p.getId() == id) return p;
        }
        return null;

    }

    @Override
    public void delete(long id) {
        for (Produit p:listProduit) {
            if (p.getId() == id) {
                listProduit.remove(p);
                System.out.println("Produit supprimé avec succés");}
        }
        System.out.println("Produit introuvable, merci de réessayer avec un ID correct");

    }
}
