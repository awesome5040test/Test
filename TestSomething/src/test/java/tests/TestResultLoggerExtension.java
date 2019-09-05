package tests;

import common.Session;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback, AfterTestExecutionCallback {
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LOGGER.info("Test result summary for " + context.getDisplayName() +" " + summary.toString());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Session.setTestResult(!extensionContext.getExecutionException().isPresent());
    }

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        LOGGER.info("Test Successful for test: " + context.getDisplayName());
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test Aborted for test: " + context.getDisplayName());
        testResultsStatus.add(TestResultStatus.ABORTED);

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test Aborted for test: " + context.getDisplayName());
        testResultsStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        LOGGER.info("Test Disabled for test: with reason :- " +
                context.getDisplayName() + " " +
                reason.orElse("No reason"));
        testResultsStatus.add(TestResultStatus.DISABLED);
    }
}

