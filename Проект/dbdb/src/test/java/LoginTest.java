import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/login.feature", "features/spam.feature", "features/zflags.feature", "features/sendMessage.feature"})
public class LoginTest {
}
