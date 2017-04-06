package interpret;

public class Super {
    int defaultSuperField;
    private int privateSuperField;
    protected int protectedSuperField;
    public int publicSuperField;

    //サブクラスからの暗黙的呼び出し用コンストラクタ
    protected Super() {
    }

    Super(int defaultValue) {
        defaultSuperField = defaultValue;
    }

    private Super(int defaultValue, String privateValue) {
        defaultSuperField = defaultValue;
        //privateSuperField = privateValue;
    }

    protected Super(int defaultValue, int privateValue, int protectedValue) {
        defaultSuperField = defaultValue;
        privateSuperField = privateValue;
        protectedSuperField = protectedValue;
    }

    public Super(int defaultValue, int privateValue, int protectedValue, int publicValue) {
        defaultSuperField = defaultValue;
        privateSuperField = privateValue;
        protectedSuperField = protectedValue;
        publicSuperField = publicValue;
    }

    void defaultSuperMethod() {
        System.out.println("defaultSuperMethodが実行されました。");
    }

    private void privateSuperMethod() {
        System.out.println("privateSuperMethodが実行されました。");
    }

    protected void protectedSuperMethod() {
        System.out.println("protectedSuperMethodが実行されました。");
    }

    public void publicSuperMethod() {
        System.out.println("publicSuperMethodが実行されました。");
    }
}