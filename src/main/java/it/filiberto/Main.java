/*
 * Copyright (c) 2022.
 * Author: Iacopo Filiberto
 */

package it.filiberto;

import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("First encoding: \n");
        executeEncoding(List.of("01010", "10010", "01110", "11101"));
        out.println("*********\n");
        out.println("Second encoding: \n");
        executeEncoding(List.of("10010111", "10010011", "01110111", "11101011"));
        out.println("*********\n");
        out.println("Third encoding: \n");
        executeEncoding(List.of("010111", "100101", "011111", "111001"));
        out.println("*********\n");
    }

    public static void executeEncoding(List<String> inputs) {
        var encoder = new ArithmeticEncoder();
        for (String input : inputs) {
            out.printf("Input string: %s%n", input);
            out.printf("N: %d%n", input.length());
            var encodedValue = encoder.encode(input);
            out.printf("A: %s%n", encodedValue);
            out.printf("Entropy: %s%n", entropy(input));
            out.printf("log(1/A/N): %s%n", Math.log(1 / encodedValue) / input.length());
            out.println("------");
        }
    }

    public static Double entropy(String input) {
        var zerosOccurences = 0;
        var onesOccurences = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                zerosOccurences++;
            } else {
                onesOccurences++;
            }
        }

        var zeroFreq = (zerosOccurences * 1.0d) / input.length();
        var oneFreq = (onesOccurences * 1.0d) / input.length();

        // H(X) = p(0) * log_2(1/p(0) + p(1) * log_2(1/p(1))
        return (zeroFreq > 0 ? zeroFreq * log2(1 / zeroFreq) : 0) + (oneFreq > 0 ? oneFreq * log2(1 / oneFreq) : 0);
    }

    // Funzione d'utilità per calcolare log2 in quanto java non ce l'ha :(
    public static Double log2(Double n) {
        return (Math.log(n) / Math.log(2));
    }
}
