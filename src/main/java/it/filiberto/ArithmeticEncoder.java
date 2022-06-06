package it.filiberto;

public class ArithmeticEncoder {

    private final Model model = new Model();

    public Double encode(String input) {
        // Start with [0, 1)
        Interval currentInterval = new Interval(0d, 1d);
        int i = 0;
        while (i < input.length()) {
            var current = Integer.parseInt(String.valueOf(input.charAt(i)));
            var start = currentInterval.lowerBound();
            var end = currentInterval.upperBound();

            Double probability = model.getProbability(0);

            // this is done like this only because we have 2 symbols in the alphabet
            Interval a = new Interval(start, start + currentInterval.getWidth() * probability);
            Interval b = new Interval(start + currentInterval.getWidth() * probability, end);
            if (current == 0) {
                currentInterval = a;
            } else {
                currentInterval = b;
            }
            model.incrementFrequency(current);
            i++;
        }

        return currentInterval.getWidth();
    }
}
