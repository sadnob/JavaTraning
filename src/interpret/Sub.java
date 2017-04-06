package interpret;

public class Sub extends Super {
    int defaultSubField;
    private int privateSubField;
    protected int protectedSubField;
    public int publicSubField;

    Sub(int defaultValue) {
        defaultSubField = defaultValue;
    }

    private Sub(int defaultValue, int privateValue) {
        defaultSubField = defaultValue;
        setPrivateSubField(privateValue);
    }

    protected Sub(int defaultValue, int privateValue, int protectedValue) {
        defaultSubField = defaultValue;
        setPrivateSubField(privateValue);
        protectedSubField = protectedValue;
    }

    public Sub(int defaultValue, int privateValue, int protectedValue, int publicValue) {
        defaultSubField = defaultValue;
        setPrivateSubField(privateValue);
        protectedSubField = protectedValue;
        publicSubField = publicValue;
    }

    void defaultSubMethod() {
        System.out.println("defaultSubMethodが実行されました。");
    }

    private void privateSubMethod() {
        System.out.println("privateSubMethodが実行されました。");
    }

    protected void protectedSubMethod() {
        System.out.println("protectedSubMethodが実行されました。");
    }

    public void publicSubMethod() {
        System.out.println("publicSubMethodが実行されました。");
    }

	public int getPrivateSubField() {
		return privateSubField;
	}

	public void setPrivateSubField(int privateSubField) {
		this.privateSubField = privateSubField;
	}
}