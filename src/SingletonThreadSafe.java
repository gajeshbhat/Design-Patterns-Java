public class SingletonThreadSafe {
/**
 * @author gajesh
 * Source : https://refactoring.guru/design-patterns/singleton/java/example#example-1
 * & https://refactoring.guru/design-patterns/singleton/java/example#example-2
 *
 * The same class behaves incorrectly in a multithreaded environment.
 * Multiple threads can call the creation method simultaneously and get several instances of Singleton class.
 *
 * */
// The field must be declared volatile so that double check lock would work
// correctly.
private static volatile SingletonThreadSafe instance;

private SingletonThreadSafe(){
    // Init the class or resource here
}

public static SingletonThreadSafe getInstance(){
    // The approach taken here is called double-checked locking (DCL). It
    // exists to prevent race condition between multiple threads that may
    // attempt to get singleton instance at the same time, creating separate
    // instances as a result.
    //
    // It may seem that having the `result` variable here is completely
    // pointless. There is, however, a very important caveat when
    // implementing double-checked locking in Java, which is solved by
    // introducing this local variable.
    //
    // You can read more info DCL issues in Java here:
    // https://refactoring.guru/java-dcl-issue

    SingletonThreadSafe currentResult = instance;
    if (currentResult != null) {
        return currentResult;
    }
    synchronized(SingletonThreadSafe.class) {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}

}
