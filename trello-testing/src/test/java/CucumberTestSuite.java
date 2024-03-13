import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,rerun:target/rerun/rerun.txt,html:target/cucumber-report/cucumber.html")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
/**
 * - use FILTER_TAGS_PROPERTY_NAME execution below, when need to use cucumber tag formula
 * - in console shows all features
 */
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@102")
/**
 *  - use junit 5 execution as IncludeTags below, when simple execution
 *  - in console shows only one scenario execution
 */
@IncludeTags("MovingCards")
//@ExcludeTags("tag01")
public class CucumberTestSuite {
}
