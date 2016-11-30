package jpl.ch03.ex05;

public class LoopBenchmark extends Benchmark {

	public int loopNum; // ループさせる回数

	public LoopBenchmark (int loopNum) {
		this.loopNum = loopNum;
	}

	@Override
	void benchmark() {
		for (int i = 0; i<=loopNum; i++) {}
	}

}
