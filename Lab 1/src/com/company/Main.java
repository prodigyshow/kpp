package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean exit = false;
        OutfitManager outfitManager = new OutfitManager();

        Outfit o = new Outfit("sport", "Nike", 200, "male", "cotton", 40,  EOutfitType.shoes);
        Outfit o1 = new Outfit("sport", "Nike", 450, "female", "cotton", 20,  EOutfitType.shoes);
        Outfit o2 = new Outfit("casual", "Adidas", 150, "female", "cotton", 50,  EOutfitType.backpacks);
        Outfit o3 = new Outfit("sport", "New Balance", 340, "female", "cotton", 70,  EOutfitType.clothes);
        Outfit o4 = new Outfit("casual", "Nike", 30, "male", "cotton", 85,  EOutfitType.caps);
        Outfit o5 = new Outfit("casual", "All Stars", 430, "female", "cotton", 90,  EOutfitType.shoes);
        Outfit o6 = new Outfit("sport", "Puma", 320, "male", "cotton", 60,  EOutfitType.backpacks);

        outfitManager.addOutfit(outfitManager, o);
        outfitManager.addOutfit(outfitManager, o1);
        outfitManager.addOutfit(outfitManager, o2);
        outfitManager.addOutfit(outfitManager, o3);
        outfitManager.addOutfit(outfitManager, o4);
        outfitManager.addOutfit(outfitManager, o5);
        outfitManager.addOutfit(outfitManager, o6);

        while(!exit) {
            System.out.println("1. Print Outfit List  ");
            System.out.println("2. Find Brand  ");
            System.out.println("3. Find Price  ");
            System.out.println("4. Sort by Material %  ");
            System.out.println("0. Exit  ");

            Scanner myInput = new Scanner(System.in);
            int option = (int)myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Outfit: ");
                    outfitManager.showAll();
                    break;
                case 2:
                    outfitManager.findBrand("Nike");
                    break;
                case 3:
                    outfitManager.findPrice(450);
                    break;
                case 4:
                    System.out.println("Choose sorting method:");
                    System.out.println("1. Sort ascending by price (OutfitManager)");
                    System.out.println("2. Sort descending by price (Inner Static Class)");
                    System.out.println("3. Sort ascending by type (Inner Class)");
                    System.out.println("4. Sort descending by type (Anonymous Inner Class)");

                    int sortMethod = (int)myInput.nextInt();
                    switch (sortMethod) {
                        case 1:
                            outfitManager.SetOutfitManager(outfitManager.sortByprocentMaterialAsc());
                            System.out.println("Done");
                            System.out.println();
                            outfitManager.showAll();
                            continue;
                        case 2:
                            outfitManager.SetOutfitManager(Outfit.InnerStaticSortingClass.sortByprocentMaterialDesc(outfitManager.getOutfitList()));
                            System.out.println("Done");
                            System.out.println();
                            outfitManager.showAll();
                            continue;
                        case 3:
                            Outfit[] out1 = new Outfit[outfitManager.getOutfitList().size()];
                            outfitManager.getOutfitList().toArray(out1);
                            outfitManager.SetOutfitManager(((Outfit) out1[0]).sortByPriceAsc(outfitManager.getOutfitList()));
                            System.out.println("Done");
                            System.out.println();
                            outfitManager.showAll();
                            continue;
                        case 4:
                            Outfit[] out2 = new Outfit[outfitManager.getOutfitList().size()];
                            outfitManager.getOutfitList().toArray(out2);
                            outfitManager.SetOutfitManager(((Outfit) out2[0]).sortByPriceDesc(outfitManager.getOutfitList()));
                            System.out.println("Done");
                            System.out.println();
                            outfitManager.showAll();
                            continue;
                    }
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }
}
