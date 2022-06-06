package it.filiberto;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private Map<Integer, Integer> frequencies;
    private Integer encounteredSymbols = 2;

    public Model() {
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
