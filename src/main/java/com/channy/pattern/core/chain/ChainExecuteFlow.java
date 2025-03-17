package com.channy.pattern.core.chain;

import com.channy.pattern.core.chain.handler.impl.LoggingExecutionHandler;
import com.channy.pattern.core.chain.handler.impl.TerminationExecutionHandler;
import com.channy.pattern.core.chain.handler.impl.ValidationExecutionHandler;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ChainExecuteFlow {
  public static void execute() {
    // Create ExecutionManager instance
    ExecutionManager<ExecutionContext> executionManager = new ExecutionManager<>();

    // Add multiple handlers
    executionManager.addHandler(new LoggingExecutionHandler());
    executionManager.addHandler(new ValidationExecutionHandler());
    executionManager.addHandler(new TerminationExecutionHandler());
    executionManager.addHandler(new LoggingExecutionHandler()); // Another logging handler

    // Test Case 1: Normal Execution
    log.info("====== Running Test Case 1: Normal Execution ======");
    ExecutionContext context1 = new ExecutionContext();
    context1.put("data", "normal");
    executionManager.execute(context1);

    // Test Case 2: Skip Next Handler
    log.info("\n====== Running Test Case 2: Skip Next Handler ======");
    ExecutionContext context2 = new ExecutionContext();
    context2.put("data", "skip");
    executionManager.execute(context2);

    // Test Case 3: Termination
    log.info("\n====== Running Test Case 3: Termination ======");
    ExecutionContext context3 = new ExecutionContext();
    context3.put("data", "stop");
    executionManager.execute(context3);
  }
}
