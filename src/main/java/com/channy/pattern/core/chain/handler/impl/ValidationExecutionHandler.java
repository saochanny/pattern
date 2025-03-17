package com.channy.pattern.core.chain.handler.impl;

import com.channy.pattern.core.chain.ExecutionContext;
import com.channy.pattern.core.chain.ExecutionState;
import com.channy.pattern.core.chain.handler.AbstractExecutionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler that validates data in the execution context.
 */
@Slf4j
public class ValidationExecutionHandler implements AbstractExecutionHandler<ExecutionContext> {

  @Override
  public ExecutionState execute(ExecutionContext context) {
    log.info("Executing ValidationExecutionHandler with context: {}", context);

    // Example condition: If context contains "skip", skip the next handler
    String data = context.get("data", String.class);
    if ("skip".equalsIgnoreCase(data)) {
      log.warn("Validation failed, skipping next handler...");
      return ExecutionState.SKIP_NEXT;
    }

    return ExecutionState.NEXT; // Continue to the next handler
  }
}
