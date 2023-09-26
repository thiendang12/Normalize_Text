package util;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class Library {

    static Scanner sc = new Scanner(System.in);

    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = getString("Do you want to continue (Y/N)? ");
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public int getInt(String promt, int min, int max) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= min && a <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        }
        return a;
    }

    public int getInt(String promt) {
        Integer a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a != null) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }

    public int getId(String promt, Predicate<Integer> p, String fiterString) {
        Integer a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a != null) {
                    if (p.test(a)) {
                        break;
                    } else {
                        System.out.println(fiterString);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }

    public String getString(String promt) {
        String result = "";
        while (true) {
            System.out.print(promt + ": ");
            try {
                result = sc.nextLine().trim();

                if (!result.isEmpty()) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a String");
            }
        }
        return result;

    }

    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

    public double getDouble(String promt) {
        Double a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Double.parseDouble(s);
                if (a != null) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }
}
