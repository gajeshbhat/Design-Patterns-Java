/**
 * @author gajesh
 * Source : https://refactoring.guru/design-patterns/singleton/java/example#example-0
 *
 * Singleton is a creational design pattern,
 * which ensures that only one object of its kind exists and provides a single point of access to it for any other code.
 *
 * Singleton has almost the same pros and cons as global variables. Although they’re super-handy,
 * they break the modularity of your code.
 *
 * You can’t just use a class that depends on Singleton in some other context. You’ll have to carry the Singleton class as well.
 * Most of the time, this limitation comes up during the creation of unit tests.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){
        /// Initialize Unique Instance here
    }

    // Lazy Loading
    public static Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
