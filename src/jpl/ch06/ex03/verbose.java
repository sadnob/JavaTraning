package jpl.ch06.ex03;

public interface verbose {
	enum MessageLevel {
		SILENT(0),
		TERSE(1),
		NORMAL(2),
		VERBOSE(3);

		private int level;
		MessageLevel(int level) {
			this.level= level;
		}

		int getLevel(){ return level;};
	}

	void setVerbosity(int level);
	int getVerbosity();

}
