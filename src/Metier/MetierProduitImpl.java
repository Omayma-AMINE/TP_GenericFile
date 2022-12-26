package Metier;

import Metier.IMetier;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {

    List <Produit> listProduit = new ArrayList();

    @Override
    public void add(Produit o) {
        listProduit.add(o);
    }

    @Override
    public List<Produit> getAll() {

        return listProduit;
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
