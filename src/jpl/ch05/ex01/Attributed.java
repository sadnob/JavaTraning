/*
 * Attributedインタフェースの中にAttrクラスを定義するべき
 * AttrクラスはAttributedインタフェースを実装するクラスに共通して必要なクラスのため
 *
 */

package jpl.ch05.ex01;

public interface Attributed
{
    void add(Attr newAttr);

    Attr find(String attrName);

    Attr remove(String arrtName);

    java.util.Iterator<Attr> attrs();

    public class Attr
    {
        private final String name;
        private Object value = null;

        public Attr(String name)
        {
            this.name = name;
        }

        public Attr(String name, Object value)
        {
            this.name = name;
            this.value = value;
        }

        public String getName()
        {
            return name;
        }

        public Object getValue()
        {
            return value;
        }

        public Object setValue(Object newValue)
        {
            Object oldVal = value;
            value = newValue;
            return oldVal;
        }

        public String toString()
        {
            return name + "='" + value + "'";
        }
    }
}