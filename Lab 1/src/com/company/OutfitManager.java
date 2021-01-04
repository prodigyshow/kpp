package com.company;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

interface Sort {
    List<Outfit> sort(List<Outfit> outfitList);
}

public class OutfitManager {
    private List<Outfit> OutfitList;

    public OutfitManager() {
        this.OutfitList =new ArrayList<>();
    }

    public List<Outfit> getOutfitList() {
        return OutfitList;
    }

    public void SetOutfitManager(List<Outfit> _outfitList) {
        OutfitList = _outfitList;
    }

    public List<Outfit> sortByprocentMaterialAsc() {
        Sort sortPrMaterAsc = (outfitList) -> {
            Collections.sort(OutfitList, Comparator.comparing(Outfit::getProcentMaterial));
            return outfitList;
        };

        return sortPrMaterAsc.sort(OutfitList);
    }

    public List<Outfit> sortByprocentMaterialDesc() {
        Sort sortPrMaterDesc = (outfitList) -> {
            Collections.sort(OutfitList, Comparator.comparing(Outfit::getProcentMaterial).reversed());
            return outfitList;
        };

        return sortPrMaterDesc.sort(OutfitList);
    }

    public List<Outfit> sortByPriceAsc() {
        Sort sortPriceAsc = (outfitList) -> {
            Collections.sort(OutfitList, Comparator.comparing(Outfit::getPrice));
            return outfitList;
        };
        return sortPriceAsc.sort(OutfitList);
    }
    public List<Outfit> sortByPriceDesc() {
        Sort sortPriceDesc = (outfitList) -> {
            Collections.sort(OutfitList, Comparator.comparing(Outfit::getPrice).reversed());
            return outfitList;
        };
        return sortPriceDesc.sort(OutfitList);
    }

    public void ShowList(List<Outfit> outfitList) {
        if (outfitList.isEmpty()) {
            System.out.println("No such items");
        } else {
            for (Outfit outfit : outfitList) {
                System.out.println("category: [" + outfit.getOutfitCategory() + "], brand: " + outfit.getBrand() + "  $" + outfit.getPrice() + " [sex:] " + outfit.getSex() + " [type:] " + outfit.getType() + " material: " + outfit.getMaterial() + " " + outfit.getProcentMaterial() +"%");
            }

        }
        System.out.println();
    }

    public  void showAll() {
        ShowList(OutfitList);
    }

    public void addItem(Outfit outs) {
        OutfitList.add(outs);
    }

    public void addOutfit(OutfitManager outman, Outfit out) {
        outman.addItem(out);
    }

    public void findBrand(String brand) {
        List<Outfit> BrandOut = new ArrayList<>();
        for (Outfit elem : OutfitList) {
            if (elem.getBrand() == brand) {
                BrandOut.add(elem);
            }
        }
        ShowList(BrandOut);
    }

    public void findPrice(double price) {
        List<Outfit> PriceOut = new ArrayList<>();
        for (Outfit elem : OutfitList) {
            if (elem.getPrice() == price) {
                PriceOut.add(elem);
            }
        }
        ShowList(PriceOut);
    }
}
