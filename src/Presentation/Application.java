package Presentation;

import Metier.MetierProduitImpl;
import Metier.Produit;

import java.util.Scanner;

public class Application {
    public static MetierProduitImpl produits = new MetierProduitImpl();
    public static void printMenu(String[] options){
        for (String option: options) {
            System.out.println(option);
        }
        System.out.print("Veuillez choisir : ");
    }
    public static void nouveauProduit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisir l'ID du produit : ");
        long id = sc.nextLong();
        System.out.print("Saisir le nom du produit :");
        String nom = sc.next();
        System.out.print("Saisir la marque du produit :");
        String marque = sc.next();
        System.out.print("Saisir la description du produit :");
        String description = sc.next();
        System.out.print("Saisir le prix du produit :");
        double prix = sc.nextDouble();
        System.out.print("Saisir la quantité du produit en stock :");
        int qte = sc.nextInt();

        Produit p = new Produit(id,nom,marque,prix,description,qte);
        produits.add(p);
        System.out.println("Produit bien ajouté");
    }
    public static void removeProduit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisir l'ID du produit : ");
        long id = sc.nextLong();
        produits.delete(id);

    }
    public static void searchByID(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisir l'ID du produit : ");
        long id = sc.nextLong();
        if (produits.findById(id)!=null) System.out.println(produits.findById(id));
        else System.out.println("Produit introuvable, merci de réessayer avec un ID correct");
    }
    public static void main(String[] args) {

        String[] options = {"1- Afficher la liste des produits",
                            "2- Rechercher un produit par son id",
                            "3- Ajouter un nouveau produit dans la liste",
                            "4- Supprimer un produit par id",
                            "5- Quitter ce programme",
        };

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option<5 && option >= 1){
            printMenu(options);
            option = scanner.nextInt();
            switch (option){
                case 1 :  System.out.println(produits.getAll());break;
                case 2 :  searchByID();break;
                case 3 : nouveauProduit();produits.saveAll();break;
                case 4 : removeProduit();break;

            }

        }

       /* Produit p1 = new Produit(1,"Phone","Samsung",9500,"Z3",10);
        Produit p2 = new Produit(2,"Phone","IPHONE",15000,"XMAX",5);
        Produit p3 = new Produit(15,"Phone","Samsung",6500,"S20",2);
        MetierProduitImpl produits = new MetierProduitImpl();
        produits.add(p1);
        produits.add(p2);
        produits.add(p3);

        System.out.println(produits.getAll());
        System.out.println(produits.findById(1));
        produits.delete(2);
        System.out.println(produits.getAll());*/

    }
}
