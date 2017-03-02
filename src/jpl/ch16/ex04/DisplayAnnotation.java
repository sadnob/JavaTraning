package jpl.ch16.ex04;

import java.lang.annotation.Annotation;

public class DisplayAnnotation {
    public void showAllAnnotation(Class<?> c)
    {
        Annotation[] tmp;
        tmp = c.getAnnotations();
        for (int i = 0; i < tmp.length; i++)
        {
            System.out.println(tmp[i]);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    	DisplayAnnotation test = new DisplayAnnotation();
        try
        {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            test.showAllAnnotation(c);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("unknown class: " + args[0]);
        }
    }
}
