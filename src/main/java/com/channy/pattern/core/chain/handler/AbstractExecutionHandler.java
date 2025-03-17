package com.channy.pattern.core.chain.handler;


import com.channy.pattern.core.chain.ExecutionContext;
import com.channy.pattern.core.chain.ExecutionState;

/**
 * Defines a handler for processing an execution context.
 *
 * @param <T> the type of the execution context
 */
public interface AbstractExecutionHandler<T extends ExecutionContext> {

  /**
   * Executes the handler logic using the provided execution context.
   *
   * @param context the execution context to process
   * @return the state indicating the result of the execution
   */
  ExecutionState execute(T context);
}
