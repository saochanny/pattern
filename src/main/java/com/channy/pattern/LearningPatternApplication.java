package com.channy.pattern;

import com.channy.pattern.core.chain.ChainExecuteFlow;
import com.channy.pattern.core.singleton.SingletonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
@EnableCaching
public class LearningPatternApplication {

  public static void main(String[] args) {
    SpringApplication.run(LearningPatternApplication.class, args);

    // Get Singleton Instances
    DatabaseConnection db1 = SingletonFactory.getInstance(DatabaseConnection.class);
    DatabaseConnection db2 = SingletonFactory.getInstance(DatabaseConnection.class);
    ConfigManager config1 = SingletonFactory.getInstance(ConfigManager.class);
    ConfigManager config2 = SingletonFactory.getInstance(ConfigManager.class);


    // Test Singleton Behavior
    log.info("db1 = db2 (same instance) : {}",db1 == db2); // true (Same instance)
    log.info("config1 = config2 (same instance) : {}",config1 == config2); // true (Same instance)


    // Use the instances
    db1.connect();
    config1.load();

    // execute flow of chain
    ChainExecuteFlow.execute();
  }

  // Sample singleton classes
  static class DatabaseConnection {
    private DatabaseConnection() {} // Private constructor

    public void connect() {
      log.info("Connected to DB");
    }
  }

  static class ConfigManager {
    private ConfigManager() {} // Private constructor

    public void load() {
      log.info("Loaded Config");
    }
  }
}
