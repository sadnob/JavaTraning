package jpl.ch17.ex03;

public class ResourceImple implements Resource{
	int keyHash;
	boolean needsRelease = false;

	ResourceImple(Object key) {
		keyHash = System.identityHashCode(key);

		// ... 外部リソースの設定

		needsRelease = true;
	}

	@Override
	public void use(Object key, Object... args) {
		if (System.identityHashCode(key) != keyHash)
			throw new IllegalArgumentException("wrong key");

		// ... リソースの使用 ...
	}

	@Override
	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;

			// .. リソースの解放 ..
		}

	}

}
