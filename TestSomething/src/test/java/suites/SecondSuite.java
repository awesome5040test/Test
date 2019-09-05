package suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.FirstTest;
import tests.SecondTest;
import tests.ThirdTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({FirstTest.class, SecondTest.class, ThirdTest.class})
public class SecondSuite {
}
