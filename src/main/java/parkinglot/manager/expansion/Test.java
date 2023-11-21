package parkinglot.manager.expansion;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 23:41
 */
public class Test {
    public static void main(String[] args) {
        ExpansionStrategy1Singleton s1 = new ExpansionStrategy1Singleton();
        ExpansionStrategy1Singleton s2 = new ExpansionStrategy1Singleton();
        System.out.println(s1.getClass());
        System.out.println(s2.getClass());
        System.out.println(s1.equals(s2));

        AbstractExpansionStrategy s3 = new ExpansionStrategy1Singleton();
        System.out.println(s3.getClass());
    }
}
