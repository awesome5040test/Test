package common;

public class Session {
    private static boolean testResult;

    public static boolean isTestResult() {
        return testResult;
    }

    public static void setTestResult(boolean testResult) {
        Session.testResult = testResult;
    }
}
