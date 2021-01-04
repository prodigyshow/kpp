package com.company;
import java.util.*;
import java.io.File;
public class Manager {

    public static Map<String, List<Clubs>> PutDataToMap(List<Clubs> clubsList) {
        Map<String, List<Clubs>> resultMap = new TreeMap<String, List<Clubs>>();

        for (Clubs club: clubsList) {
            if (!resultMap.containsKey(club.getCity())) {
                resultMap.put(club.getCity(), new LinkedList<Clubs>());
            }
            resultMap.get(club.getCity()).add(club);
        }

        return resultMap;
    }

    public static void PrintMap(Map<String, List<Clubs>> map) {
        for (String key : map.keySet()) {
            System.out.println(key);
            for (Clubs club : map.get(key)) {
                System.out.println("    " + club.getName() + ", " + club.getFoundationDate());
            }
        }
    }

    public static void PrintMap(Map<String, List<Clubs>> map, int n) {
        if(n < 0){
            PrintMap(map);
        }

        for (String key : map.keySet()) {
            int counter = 0;
            System.out.println(key);
            for (Clubs club : map.get(key)) {
                if ((++counter) > n) {
                    continue;
                }
                System.out.println("    " + club.getName() + ", " + club.getFoundationDate());
            }
        }
    }

    public static int SimilarClubCount(Map<String, List<Clubs>> map){

        Set<String> citiesWithSimilarClub = new TreeSet<>();

        String[] keySet = new String[map.size()];
        map.keySet().toArray(keySet);

        for (int i = 0; i < keySet.length; ++i){
            for (int j = i; j < keySet.length; ++j){
                if(i == j){
                    continue;
                }
                List<Clubs> clubs = CommonElements(map.get(keySet[i]), map.get(keySet[j]));

                if(!clubs.isEmpty()){
                    citiesWithSimilarClub.add(keySet[i]);
                    citiesWithSimilarClub.add(keySet[j]);
                }
            }
        }
        return citiesWithSimilarClub.size();
    }

    public static Map<String, List<Clubs>> ReadFromFiles(MergeOptions mergeOption)
    {
        Map<String, List<Clubs>> map1 = new TreeMap<String, List<Clubs>>();
        Map<String, List<Clubs>> map2 = new TreeMap<String, List<Clubs>>();
        List<Clubs> footballClubs1 = new LinkedList<Clubs>(){};
        List<Clubs> footballClubs2 = new LinkedList<Clubs>(){};

        String fileName1 = "C:\\Users\\maxty\\Documents\\KPP\\f1.txt";
        String fileName2 = "C:\\Users\\maxty\\Documents\\KPP\\f3.txt";

        ReadFile(footballClubs1, fileName1);
        ReadFile(footballClubs2, fileName2);

        map1 = PutDataToMap(footballClubs1);
        map2 = PutDataToMap(footballClubs2);

        switch (mergeOption){
            case ALL:
                return MergeMaps(map1, map2);
            case COMMON:
                return MergeSimilarFromMaps(map1, map2);
        }
        return MergeMaps(map1, map2);
    }

    private static void ReadFile(List<Clubs> clubs, String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNextLine()){
                String name = myReader.next();
                String city = myReader.next();
                String year = myReader.next();

                clubs.add(new Clubs(name, city, Integer.parseInt(year)));
            }
            myReader.close();
        }
        catch (Exception e){
            System.out.println("Error with file " + fileName);
        }
    }

    public static Map<String, List<Clubs>> MergeMaps(Map<String, List<Clubs>> map1, Map<String, List<Clubs>> map2){
        Map<String, List<Clubs>> resultMap = new TreeMap<String, List<Clubs>>(map1);

        for(String key : map2.keySet()){
            if(!resultMap.containsKey(key)){
                resultMap.put(key, map2.get(key));
            }
            else{
                for (Clubs club : map2.get(key)){
                    if(!resultMap.get(key).contains(club)){
                        resultMap.get(key).add(club);
                    }
                }
            }
        }

        return resultMap;
    }

    public static Map<String, List<Clubs>> MergeSimilarFromMaps(Map<String, List<Clubs>> map1, Map<String, List<Clubs>> map2){
        Map<String, List<Clubs>> resultMap = new TreeMap<String, List<Clubs>>();

        for(String key : map1.keySet()){
            if(map2.containsKey(key) && !CommonElements(map1.get(key), map2.get(key)).isEmpty()){
                resultMap.put(key, CommonElements(map1.get(key), map2.get(key)));
            }
        }

        return resultMap;
    }

    public static List<Clubs> CommonElements(List<Clubs> f1, List<Clubs> f2){
        List<Clubs> resultList = new LinkedList<>();

        for (Clubs club : f1){
            if(f2.contains(club)){
                resultList.add(club);
            }
        }

        return resultList;
    }
}

enum MergeOptions{
    ALL,
    COMMON
}
