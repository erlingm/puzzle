# puzzle
A timing puzzle sequential vs parallel for BigInteger multiplication
_(based on one of the puzzles by Dr. Heinz M. Kabutz)_

Simple Java project in IntelliJ, and using Java 16 for compilation.

## The puzzle
The puzzle is why running the calculation in parallel is not a factor smaller than the number of processors of the computer, compared to running it sequentally. _I do not know the answer._

## Sample run
On my computer:
<pre>
Processor	Intel(R) Xeon(R) W-1290P CPU @ 3.70GHz   3.70 GHz
Installed RAM	96,0 GB (95,9 GB usable)
System type	64-bit operating system, x64-based processor
</pre>
## Summary run times

Java vendor version: AdoptOpenJDK-16.0.1+9

Available processors: 20

| Upper limit | Iter | Factor | Sequential<br>run time | Parallel<br>run time |
| ----------- | ---- | ------ | ------------- | ------------- |
|   200,000   |   1  |  35.36 |    7,285 ms   |     206 ms    |
|   200,000   |   2  |  61.91 |    7,182 ms   |     116 ms    |
|   200,000   |   3  |  64.55 |    7,165 ms   |     111 ms    |
|   200,000   |   4  |  64.31 |    7,138 ms   |     111 ms    |
|   200,000   |   5  |  64.51 |    7,161 ms   |     111 ms    |
|   200,000   |   6  |  63.90 |    7,157 ms   |     112 ms    |
|   200,000   |   7  |  62.61 |    7,138 ms   |     114 ms    |
|   200,000   |   8  |  63.27 |    7,150 ms   |     113 ms    |
|   200,000   |   9  |  62.66 |    7,143 ms   |     114 ms    |
|   200,000   |  10  |  57.82 |    7,170 ms   |     124 ms    |
| |
|   500,000   |   1  |  92.25 |   48,341 ms   |     524 ms    |
|   500,000   |   2  |  90.45 |   48,299 ms   |     534 ms    |
|   500,000   |   3  |  77.67 |   48,311 ms   |     622 ms    |
|   500,000   |   4  |  89.69 |   48,253 ms   |     538 ms    |
|   500,000   |   5  |  90.71 |   48,256 ms   |     532 ms    |
|   500,000   |   6  |  90.17 |   48,509 ms   |     538 ms    |
|   500,000   |   7  |  90.47 |   48,490 ms   |     536 ms    |
|   500,000   |   8  |  90.85 |   48,513 ms   |     534 ms    |
|   500,000   |   9  |  89.15 |   48,500 ms   |     544 ms    |
|   500,000   |  10  |  90.26 |   48,472 ms   |     537 ms    |
|             |
|  1,000,000  |   1  | 121.29 |  205,104 ms   |   1,691 ms    |
|  1,000,000  |   2  | 118.57 |  204,298 ms   |   1,723 ms    |
|  1,000,000  |   3  | 120.00 |  204,354 ms   |   1,703 ms    |
|  1,000,000  |   4  | 119.35 |  204,094 ms   |   1,710 ms    |
|  1,000,000  |   5  | 119.16 |  204,951 ms   |   1,720 ms    |
|  1,000,000  |   6  | 119.41 |  205,379 ms   |   1,720 ms    |
|  1,000,000  |   7  | 120.77 |  203,979 ms   |   1,689 ms    |
|  1,000,000  |   8  | 119.40 |  204,764 ms   |   1,715 ms    |
|  1,000,000  |   9  | 118.70 |  205,106 ms   |   1,728 ms    |
|  1,000,000  |  10  | 118.83 |  205,105 ms   |   1,726 ms    |

## Run details
<pre>
"C:\Program Files\AdoptOpenJDK\jdk-16.0.1.9-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2021.1\lib\idea_rt.jar=62115:C:\Program Files\JetBrains\IntelliJ IDEA 2021.1\bin" -Dfile.encoding=UTF-8 -classpath F:\work\javaspecialists\puzzle\out\production\puzzle no.moldesoft.puzzle.Main
Available processors: 20
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,285 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 206 ms

Factor iteration 1 for upper limit 200,000: 35.36
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,182 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 116 ms

Factor iteration 2 for upper limit 200,000: 61.91
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,165 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 111 ms

Factor iteration 3 for upper limit 200,000: 64.55
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,138 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 111 ms

Factor iteration 4 for upper limit 200,000: 64.31
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,161 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 111 ms

Factor iteration 5 for upper limit 200,000: 64.51
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,157 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 112 ms

Factor iteration 6 for upper limit 200,000: 63.90
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,138 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 114 ms

Factor iteration 7 for upper limit 200,000: 62.61
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,150 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 113 ms

Factor iteration 8 for upper limit 200,000: 63.27
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,143 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 114 ms

Factor iteration 9 for upper limit 200,000: 62.66
parallel = false
Bitcount:  1,516,732
BitLength: 3,233,382
time = 7,170 ms

parallel = true
Bitcount:  1,516,732
BitLength: 3,233,382
time = 124 ms

Factor iteration 10 for upper limit 200,000: 57.82
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,341 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 524 ms

Factor iteration 1 for upper limit 500,000: 92.25
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,299 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 534 ms

Factor iteration 2 for upper limit 500,000: 90.45
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,311 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 622 ms

Factor iteration 3 for upper limit 500,000: 77.67
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,253 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 538 ms

Factor iteration 4 for upper limit 500,000: 89.69
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,256 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 532 ms

Factor iteration 5 for upper limit 500,000: 90.71
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,509 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 538 ms

Factor iteration 6 for upper limit 500,000: 90.17
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,490 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 536 ms

Factor iteration 7 for upper limit 500,000: 90.47
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,513ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 53 ms

Factor iteration 8 for upper limit 500,000: 90.85
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,50 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 54 ms

Factor iteration 9 for upper limit 500,000: 89.15
parallel = false
Bitcount:  4,121,937
BitLength: 8,744,429
time = 48,47 ms

parallel = true
Bitcount:  4,121,937
BitLength: 8,744,429
time = 53 ms

Factor iteration 10 for upper limit 500,000: 90.26
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 205,10 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,69 ms

Factor iteration 1 for upper limit 1,000,000: 121.29
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 204,29 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,72 ms

Factor iteration 2 for upper limit 1,000,000: 118.57
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 204,35 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,70 ms

Factor iteration 3 for upper limit 1,000,000: 120.00
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 204,09 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,71 ms

Factor iteration 4 for upper limit 1,000,000: 119.35
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 204,95 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,72 ms

Factor iteration 5 for upper limit 1,000,000: 119.16
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 205,37 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,72 ms

Factor iteration 6 for upper limit 1,000,000: 119.41
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 203,97 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,68 ms

Factor iteration 7 for upper limit 1,000,000: 120.77
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 204,76 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,71 ms

Factor iteration 8 for upper limit 1,000,000: 119.40
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 205,10 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,72 ms

Factor iteration 9 for upper limit 1,000,000: 118.70
parallel = false
Bitcount:  8,746,329
BitLength: 18,488,865
time = 205,10 ms

parallel = true
Bitcount:  8,746,329
BitLength: 18,488,865
time = 1,72 ms

Factor iteration 10 for upper limit 1,000,000: 118.83
</pre>