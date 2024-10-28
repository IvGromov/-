package ru.Ivan.ErrorCheck;

public class Main {
    private static int SumOf(String[][] Array) throws AppArraySizeException, AppArrayDataException {
        checkArraySize(Array, 4);
        int Sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try{
                    Sum += Integer.parseInt(Array[i][j]);
                } catch(NumberFormatException e) {
                    throw new AppArrayDataException("Данные в массиве не являются целыми числами");
                }
            }
        }
        return Sum;
    }

    public static boolean checkArraySize(String[][] array, int size) throws AppArraySizeException {
        if (array.length != size && array[0].length != size) {
            throw new AppArraySizeException("Недопустимый размер массива");
        } else {
            return true;
        }
    }

    public static boolean checkInt(String a) throws AppArraySizeException {
        try{
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e){
            new AppArrayDataException("Данные в массиве не являются целыми числами");
            return false;
        }
    }

    public static class AppArraySizeException extends Exception {
        public AppArraySizeException(String message) {
            super(message);
        }
    }

    public static class AppArrayDataException extends Exception {
        public AppArrayDataException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws AppArraySizeException, AppArrayDataException {
        String[][] arr1 = {{"1","2"},{"3","3"}};
        String[][] arr2 = {{"1","1","1","1"}, {"2","2","2","2"}, {"3","3","3","3"}, {"4","4","4","4"}};
        String[][] arr3 = {{"1","2","3","4"}, {"e","u","r","t"}, {"3","3","3","3"}, {"4","4","4","4"}};

        int sum = 0;

        sum = SumOf(arr2);
        System.out.println(sum);
    }
}
