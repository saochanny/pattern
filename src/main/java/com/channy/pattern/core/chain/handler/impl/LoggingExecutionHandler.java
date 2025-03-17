package com.channy.pattern.core.chain.handler.impl;

import com.channy.pattern.core.chain.ExecutionContext;
import com.channy.pattern.core.chain.ExecutionState;
import com.channy.pattern.core.chain.handler.AbstractExecutionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler that logs execution.
 */
@Slf4j
public class LoggingExecutionHandler implements AbstractExecutionHandler<ExecutionContext> {

  @Override
  public ExecutionState execute(ExecutionContext context) {
    log.info("Executing LoggingExecutionHandler with context: {}", context);
    return ExecutionState.NEXT; // Proceed to the next handler
  }
}