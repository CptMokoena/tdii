/*
 * Copyright (c) 2022.
 * Author: Iacopo Filiberto
 */

package it.filiberto;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Map<Integer, Integer> frequencies;
    private Integer encounteredSymbols = 2;

    public Model() {
        // Mappa inizializzata così per fare in modo che 0 e 1 siano equiprobabili
        frequencies = new HashMap<>();
        frequencies.put(0, 1);
        frequencies.put(1, 1);
    }

    public void incrementFrequency(Integer symbol) {
        frequencies.compute(symbol, (k, v) -> (v == null) ? 1 : v + 1);
        encounteredSymbols++;
    }
    public Double getProbability(Integer symbol) {
        return (frequencies.get(symbol) * 1.0d) / encounteredSymbols;
    }
}
