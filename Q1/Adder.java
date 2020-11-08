public class Adder{
    public static void main(String[] args){
        int sum = 0;
        String result = "";
        for(String temp:args){
            if (isNumeric(temp)){
                result += " + " + Integer.parseInt(temp);
                sum += Integer.parseInt(temp);
            }
        }
        if (result.length() > 0){
            result = result.substring(3);
            System.out.print(result + " = " + sum);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}