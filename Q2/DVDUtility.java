import java.util.*; 

public class DVDUtility{
    public static DVD getMostExpensiveDVD(DVD[] arr){
        try{
            double mostExpensive = arr[0].getPrice();
            DVD mostExpensiveDvd = arr[0];
            for (DVD dvd:arr){
                if (dvd.getPrice() > mostExpensive){
                    mostExpensive = dvd.getPrice();
                    mostExpensiveDvd = dvd;
                }
            }
            return mostExpensiveDvd;
        } catch(NullPointerException e){
            return null;
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public static List<DVD> getDVDWithGenre(DVD[] arr, String genre){
        List<DVD> DVDWithGenre = new ArrayList<>();
        try{
            for (DVD dvd:arr){
                if (dvd.getGenre().equals(genre)){
                    DVDWithGenre.add(dvd);
                }
            }
            return DVDWithGenre;
        } catch(NullPointerException e){
            return null;
        }
    }

    public static List<DVD> getDVDWithPriceBetween(DVD[] arr, int minPrice, int maxPrice){
        List<DVD> DVD = new ArrayList<>();
        for (DVD dvd:arr){
            if (dvd.getPrice() >= minPrice && dvd.getPrice() < maxPrice){
                DVD.add(dvd);
            }
        }
        return DVD;
    }

    public static List<DVD> getUniqueDVDs(DVD[] arr, DVD[] anotherArray){
        List<DVD> DVDUnique = new ArrayList<>();
        try{
            List<String> temp1 = new ArrayList<>();
            List<String> temp2 = new ArrayList<>();
            for (DVD dvd:arr){
                temp1.add(dvd.getTitle());
            }
            for (DVD dvd:anotherArray){
                temp2.add(dvd.getTitle());
            }
            for (DVD dvd:arr){
                if (!temp2.contains(dvd.getTitle())){
                    DVDUnique.add(dvd);
                }
            }
            for (DVD dvd:anotherArray){
                if (!temp1.contains(dvd.getTitle())){
                    DVDUnique.add(dvd);
                }
            }
            return DVDUnique;
        } catch(NullPointerException e){
            return Arrays.asList(anotherArray);
        }
    }

    public static String[] getDVDTitlesInYear(DVD[] arr, int year){
        try{
            List<String> DVD = new ArrayList<>();
            for (DVD dvd:arr){
                if (dvd.getYear() == year){
                    DVD.add(dvd.getTitle());
                }
            }
            String[] result = new String[DVD.size()];
            int index = 0;
            for(String title:DVD){
                result[index] = title;
                index++;
            }
            return result;
        } catch(NullPointerException e){
            return new String[0];
        }
    }
}