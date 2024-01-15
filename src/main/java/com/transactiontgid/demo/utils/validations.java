package com.transactiontgid.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class validations {

  public static Boolean validateNaturalRegistry(String cpf) {
    Integer size = cpf.length();

    if (size != 11) {
      return false;
    }

    char[] digits = cpf.toCharArray();
    ArrayList<Integer> intDigits = charToIntList(digits);
    ArrayList<Integer> weightDigits = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2));

    int sumDV1 = 0;
    for (int i = 0; i < weightDigits.size(); i++) {
      sumDV1 += intDigits.get(i) * weightDigits.get(i);
    }

    Integer DV1 = 0;
    if (sumDV1 % 11 >= 2) {
      DV1 = 11 - (sumDV1 % 11);
    }

    if (!DV1.equals(intDigits.get(9))) {
      return false;
    }

    weightDigits.add(0, 11);

    int sumDV2 = 0;
    for (int i = 0; i < weightDigits.size(); i++) {
      sumDV2 += intDigits.get(i) * weightDigits.get(i);
    }

    Integer DV2 = 0;
    if (sumDV2 % 11 >= 2) {
      DV2 = 11 - (sumDV2 % 11);
    }

    if (!DV2.equals(intDigits.get(10))) {
      return false;
    }

    return true;
  }

  public static Boolean validateLegalRegistry(String cnpj) {
    Integer size = cnpj.length();

    if (size != 14) {
      return false;
    }

    char[] digits = cnpj.toCharArray();
    ArrayList<Integer> intDigits = charToIntList(digits);
    Integer[] weight = new Integer[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    ArrayList<Integer> weightDigits = new ArrayList<>(Arrays.asList(weight));

    int sumDV1 = 0;
    for (int i = 0; i < weightDigits.size(); i++) {
      sumDV1 += intDigits.get(i) * weightDigits.get(i);
    }

    Integer DV1 = 0;
    if (sumDV1 % 11 >= 2) {
      DV1 = 11 - (sumDV1 % 11);
    }

    if (!DV1.equals(intDigits.get(12))) {
      return false;
    }

    weightDigits.add(0, 6);

    int sumDV2 = 0;
    for (int i = 0; i < weightDigits.size(); i++) {
      sumDV2 += intDigits.get(i) * weightDigits.get(i);
    }

    Integer DV2 = 0;
    if (sumDV2 % 11 >= 2) {
      DV2 = 11 - (sumDV2 % 11);
    }

    if (!DV2.equals(intDigits.get(13))) {
      return false;
    }

    return true;
  }

  public static ArrayList<Integer> charToIntList(char[] digits) {
    ArrayList<Integer> intDigits = new ArrayList<>();

    for (char ch : digits) {
      intDigits.add(Character.getNumericValue(ch));
    }

    return intDigits;
  }
}
