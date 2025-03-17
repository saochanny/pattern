package com.channy.pattern.core.singleton;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonFactory {
  // Store singleton instances mapped by class type
  private static final ConcurrentHashMap<Class<?>, Object> INSTANCES = new ConcurrentHashMap<>();

  // Private constructor to prevent instantiation
  private SingletonFactory() {}

  // Generic method to get or create a singleton instance
  @SuppressWarnings("unchecked")
  public static <T> T getInstance(Class<T> clazz) {
    return (T) INSTANCES.computeIfAbsent(clazz, SingletonFactory::createInstance);
  }

  // Private method to create a new instance with double-checked locking
  private static <T> T createInstance(Class<T> clazz) {
    try {
      Constructor<T> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true); // Allow access to private constructors
      return constructor.newInstance();
    } catch (Exception e) {
      throw new RuntimeException("Failed to create instance for class: " + clazz.getName(), e);
    }
  }

}
