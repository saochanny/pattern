package com.channy.pattern.core.chain;

import java.util.HashMap;
import java.util.Optional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * ExecutionContext serves as a generic storage container for execution-related data.
 *
 * <p>This class extends {@link HashMap} and allows storing and retrieving data using keys. It
 * provides type-safe methods to retrieve values while ensuring proper type casting.
 *
 * <p>This class is designed to be extended if additional properties or methods are needed for
 * specific execution contexts.
 */
@Builder
@RequiredArgsConstructor
public class ExecutionContext extends HashMap<String, Object> {
  // Add common properties or methods if needed

  /**
   * Retrieves a value from the context by its key and casts it to the specified type.
   *
   * @param <T> the expected type of the value
   * @param key the key associated with the value
   * @param clazz the class of the expected type
   * @return the value cast to the specified type, or {@code null} if the key is not present
   * @throws ClassCastException if the value cannot be cast to the specified type
   */
  public <T> T get(String key, Class<T> clazz) {
    final var value = this.get(key);
    if (value != null) {
      return clazz.cast(value);
    }
    return null;
  }

  /**
   * Retrieves a value from the context by its key and casts it to the specified type. If the key is
   * not present, returns a provided default value.
   *
   * @param <T> the expected type of the value
   * @param key the key associated with the value
   * @param clazz the class of the expected type
   * @param defaultValue the default value to return if the key is not found
   * @return the value cast to the specified type, or {@code defaultValue} if the key is not present
   */
  public <T> T getOrElse(String key, Class<T> clazz, T defaultValue) {
    final var value = this.get(key, clazz);
    return Optional.ofNullable(value).orElse(defaultValue);
  }

  /**
   * Retrieves a value from the context by its key and casts it to the specified type, returning an
   * {@link Optional} that may contain the value.
   *
   * @param <T> the expected type of the value
   * @param key the key associated with the value
   * @param clazz the class of the expected type
   * @return an {@code Optional} containing the value if present, otherwise an empty {@code
   *     Optional}
   */
  public <T> Optional<T> find(String key, Class<T> clazz) {
    final var value = this.get(key, clazz);
    if (value != null) {
      return Optional.of(clazz.cast(value));
    }
    return Optional.empty();
  }
}
