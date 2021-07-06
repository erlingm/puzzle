package no.moldesoft.puzzle;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    record Result(int iteration, int limit, BigDecimal factor) {
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runner(args);
    }

    private void runner(String[] args) {
        System.out.printf("Available processors: %,d%n", Runtime.getRuntime().availableProcessors());
        runSeqParMulReps(List.of(200_000, 500_000, 1_000_000));
    }

    private void runSeqParMulReps(List<Integer> limits) {
        List<Result> results = limits.stream()
                .flatMap(upperLimit -> IntStream.rangeClosed(1, 10)
                        .mapToObj(i -> puzzleRep(i, upperLimit)))
                .toList();
        System.out.printf("%11s %4s %9s%n", "Upper limit", "Iter", "Factor");
        results.forEach(result -> System.out.printf("%,11d %,4d %,9.2f%n", result.limit(), result.iteration(), result.factor()));
    }

    private Result puzzleRep(int iteration, int upperLimit) {
        long biSequential = multiplyPuzzle(false, upperLimit);
        System.out.println();
        long biParallel = multiplyPuzzle(true, upperLimit);
        System.out.println();
        BigDecimal bds = new BigDecimal(biSequential);
        BigDecimal bdp = new BigDecimal(biParallel);
        BigDecimal factor = bds.divide(bdp, 2, RoundingMode.HALF_UP);
        System.out.printf("Factor iteration %,d for upper limit %,d: %,.2f%n", iteration, upperLimit, factor);
        return new Result(iteration, upperLimit, factor);
    }

    private long multiplyPuzzle(boolean parallel, int upperLimit) {
        long runningTime;
        long time = System.nanoTime();
        try {
            IntStream range = IntStream.range(1, upperLimit);
            if (parallel) range = range.parallel();
            BigInteger answer = range
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);
            System.out.println("parallel = " + parallel);
            System.out.printf("Bitcount:  %,d%n", answer.bitCount());
            System.out.printf("BitLength: %,d%n", answer.bitLength());
        } finally {
            runningTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time);
            System.out.printf("time = %,dms%n", runningTime);
        }
        return runningTime;
    }

}
