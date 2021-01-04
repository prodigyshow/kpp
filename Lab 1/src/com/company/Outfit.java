package com.company;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collection;
import java.util.List;

public class Outfit implements IClothes {
    private String outfitCategory;
    private String brand;
    private double price;
    private String sex;
    EOutfitType type;
    private String material;
    private int procentMaterial;



    public Outfit(String outfitCategory, String brand, double price, String sex, String material, int procentMaterial, EOutfitType type) {
        this.outfitCategory = outfitCategory;
        this.brand = brand;
        this.price = price;
        this.sex = sex;
        this.material = material;
        this.procentMaterial = procentMaterial;
        this.type = type;
    }

    public Outfit() { }

    public String getOutfitCategory() {
        return  outfitCategory;
    }
    public String getBrand() {
        return  brand;
    }
    public double getPrice() {
        return price;
    }
    public String getSex() {
        return sex;
    }
    public String getMaterial() {
        return material;
    }
    public int getProcentMaterial() {
        return procentMaterial;
    }

    public EOutfitType getType() {
        return type;
    }

    public InnerSortingClass anonInnerSortingClass = new InnerSortingClass() {
        public List<Outfit> sortByprocentMaterialAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial));
            return outfitList;
        }
        public List<Outfit> sortByprocentMaterialDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial).reversed());
            return outfitList;
        }

        public List<Outfit> sortByPriceAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice));
            return outfitList;
        }

        public List<Outfit> sortByPriceDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice).reversed());
            return outfitList;
        }
    };

    public static class InnerStaticSortingClass {
        public static List<Outfit> sortByprocentMaterialAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial));
            return outfitList;
        }
        public static List<Outfit> sortByprocentMaterialDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial).reversed());
            return outfitList;
        }

        public static List<Outfit> sortByPriceAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice));
            return outfitList;
        }

        public static List<Outfit> sortByPriceDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice).reversed());
            return outfitList;
        }

    }

    private static class InnerSortingClass {
        InnerSortingClass() {}
        public List<Outfit> sortByprocentMaterialAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial));
            return outfitList;
        }
        public List<Outfit> sortByprocentMaterialDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getProcentMaterial).reversed());
            return outfitList;
        }

        public List<Outfit> sortByPriceAsc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice));
            return outfitList;
        }

        public List<Outfit> sortByPriceDesc(List<Outfit> outfitList) {
            Collections.sort(outfitList, Comparator.comparing(Outfit::getPrice).reversed());
            return outfitList;
        }
    }

    public InnerSortingClass getSortingClassInstance() {
        return new InnerSortingClass();
    }

    public InnerSortingClass getAnonSortingClass() {
        return anonInnerSortingClass;
    }

    public List<Outfit> sortByprocentMaterialAsc(List<Outfit> outfitList) {
        return getAnonSortingClass().sortByprocentMaterialAsc(outfitList);
    }

    public List<Outfit> sortByprocentMaterialDesc(List<Outfit> outfitList) {
        return getSortingClassInstance().sortByprocentMaterialDesc(outfitList);
    }

    public List<Outfit> sortByPriceAsc(List<Outfit> outfitList) {
        return getSortingClassInstance().sortByPriceAsc(outfitList);
    }

    public List<Outfit> sortByPriceDesc(List<Outfit> outfitList) {
        return getAnonSortingClass().sortByPriceDesc(outfitList);
    }

}

interface IClothes {}