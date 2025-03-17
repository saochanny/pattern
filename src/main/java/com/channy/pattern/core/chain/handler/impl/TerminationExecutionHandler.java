package com.channy.pattern.core.chain.handler.impl;

import com.channy.pattern.core.chain.ExecutionContext;
import com.channy.pattern.core.chain.ExecutionState;
import com.channy.pattern.core.chain.handler.AbstractExecutionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler that terminates execution based on a condition.
 */
@Slf4j
public class TerminationExecutionHandler implements AbstractExecutionHandler<ExecutionContext> {

  @Override
  public ExecutionState execute(ExecutionContext context) {
    log.info("Executing TerminationExecutionHandler with context: {}", context);

    // Example condition: If context contains "stop", terminate execution
    String data = context.get("data", String.class);
    if ("stop".equalsIgnoreCase(data)) {
      log.warn("Termination condition met. Stopping execution.");
      return ExecutionState.END;
    }

    return ExecutionState.NEXT; // Continue to the next handler
  }
}
