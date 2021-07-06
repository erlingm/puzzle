package no.moldesoft.puzzle;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    record Result(int iteration, int limit, BigDecimal factor, long biSequential, long biParallel) {
    }

    public static void main(String[] args) {
        Main main = new Main();
        Locale locale = Locale.US;
        main.runner(locale, args);
    }

    private void runner(Locale locale, String[] args) {
        System.out.printf(locale, "Available processors: %,d%n", Runtime.getRuntime().availableProcessors());
        runSeqParMulReps(locale, List.of(200_000, 500_000, 1_000_000));
    }

    private void runSeqParMulReps(Locale locale, List<Integer> limits) {
        List<Result> results = limits.stream()
                .flatMap(upperLimit -> IntStream.rangeClosed(1, 10)
                        .mapToObj(i -> puzzleRep(locale, i, upperLimit)))
                .toList();
        System.out.printf(locale, "Java vendor version: %s%n%n", System.getProperty("java.vendor.version"));
        System.out.printf(locale, "%11s %4s %9s %15s %15s%n", "Upper limit", "Iter", "Factor", "Seq. run time", "Par. run time");
        int mark = 0;
        for (Result result : results) {
            if (mark != result.limit()) {
                System.out.printf("%n");
                mark = result.limit();
            }
            System.out.printf(locale, "%,11d %,4d %,9.2f %,12d ms %,12d ms%n", result.limit(), result.iteration(), result.factor(), result.biSequential(), result.biParallel());
        }
    }

    private Result puzzleRep(Locale locale, int iteration, int upperLimit) {
        long biSequential = multiplyPuzzle(locale, false, upperLimit);
        System.out.println();
        long biParallel = multiplyPuzzle(locale, true, upperLimit);
        System.out.println();
        BigDecimal bds = new BigDecimal(biSequential);
        BigDecimal bdp = new BigDecimal(biParallel);
        BigDecimal factor = bds.divide(bdp, 2, RoundingMode.HALF_UP);
        System.out.printf(locale, "Factor iteration %,d for upper limit %,d: %,.2f%n", iteration, upperLimit, factor);
        return new Result(iteration, upperLimit, factor, biSequential, biParallel);
    }

    private long multiplyPuzzle(Locale locale, boolean parallel, int upperLimit) {
        long runningTime;
        long time = System.nanoTime();
        try {
            IntStream range = IntStream.range(1, upperLimit);
            if (parallel) range = range.parallel();
            BigInteger answer = range
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);
            System.out.println("parallel = " + parallel);
            System.out.printf(locale, "Bitcount:  %,d%n", answer.bitCount());
            System.out.printf(locale, "BitLength: %,d%n", answer.bitLength());
        } finally {
            runningTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time);
            System.out.printf(locale, "time = %,dms%n", runningTime);
        }
        return runningTime;
    }

}
