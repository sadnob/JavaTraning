package jpl.ch03.ex05;

public class BenchmarkMain {

	public static void main(String[] args) {
		LoopBenchmark bench = new LoopBenchmark(10);
		System.out.println( bench.loopNum + "回ループ ：" + bench.repeat(1) + "ナノ秒");

	}

}
