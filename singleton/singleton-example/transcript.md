## What is the Singleton Pattern?

The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. It is commonly used when you want to control access to a single instance of a class across the application.

This can be useful for scenarios where you need a single point of access to a resource, configuration settings, logging functionality, or managing a connection pool.

### Key characteristics of the Singleton pattern include:

- Private constructor: The Singleton class has a private constructor to prevent external classes from creating instances.
- Static instance: It contains a static member that holds the reference to the single instance of the class.
- Static method: It provides a static method to access the singleton instance, typically named getInstance().

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Doing something in Singleton");
    }
}
```

### There are several types or variations of the Singleton pattern. Some common types include:

- Lazy Initialization Singleton: The instance is created only when it is first requested. Lazy Initialization Singleton is useful when you want to defer the creation of the instance until it is actually needed, potentially saving resources if the Singleton is not always required. However, it's important to note that this approach may not be thread-safe in a multi-threaded environment without additional synchronization mechanisms.

```java
public class LazyInterestCalculator {

  private static LazyInterestCalculator instance;

  private LazyInterestCalculator() {
  }

  public static LazyInterestCalculator getInstance() {
    if (instance == null) {
      instance = new LazyInterestCalculator();
    }
    return instance;
  }

  public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
    return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }

}
```

- Eager Initialization Singleton: The instance is created when the class is loaded, regardless of whether it is needed. Eager Initialization Singleton provides thread safety and simplicity in implementation but may consume resources unnecessarily and lack the flexibility of lazy loading.

```java
public class EagerInterestCalculator {

  private static final EagerInterestCalculator instance = new EagerInterestCalculator();

  private EagerInterestCalculator() {
  }

  public static EagerInterestCalculator getInstance() {
    return instance;
  }

  public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
    return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }

}

```

- Thread-Safe Singleton: Ensures that the Singleton instance is created in a thread-safe manner, preventing multiple threads from creating separate instances.

    - The getInstance() method first checks if the instance is null, and if so, it enters a synchronized block to ensure only one thread can create the instance.
    - The volatile keyword is used to ensure visibility of changes to instance variable across threads.

```java
public class ThreadSafeInterestCalculator {

  private static volatile ThreadSafeInterestCalculator instance;

  private ThreadSafeInterestCalculator() {
  }

  // Double-checked locking for thread safety
  public static ThreadSafeInterestCalculator getInstance() {
    if (instance == null) {
      synchronized (ThreadSafeInterestCalculator.class) {
        if (instance == null) {
          instance = new ThreadSafeInterestCalculator();
        }
      }
    }
    return instance;
  }

  public synchronized BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
    return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }

}
```

- Enum Singleton: Uses an enum to create a Singleton with inherent serialization and thread safety. In Java, enum types are a special kind of class that can have constructors, methods, and instance variables like a regular class, but they have a finite set of predefined instances (enum constants). This makes enum types a convenient and safe way to implement the Singleton pattern with built-in thread safety and serialization guarantees.

```java
public enum EnumInterestCalculator {
  INSTANCE;

  public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
    return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }
}
```