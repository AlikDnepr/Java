package Code;

public class NumberStr {
    public static void main(String[] args){
        String numberStr = "123";
        int numberInt = Integer.parseInt(numberStr) + 10;
        System.out.println(numberInt);
        String number = new String(String.valueOf(numberInt));
        System.out.println(number);
    }

    // как проверить тип переменной в 17 версии джавы (красивый способ) в более высоких через instanceof
}
