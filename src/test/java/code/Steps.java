package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.Given;

public class Steps {

	private Properties prop;

	@Given("^prepare the environment$")
	public void prepare_the_environment() throws Exception {
		InputStream fis = null;
		try {
			fis = Steps.class.getResourceAsStream("/url.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		System.out.println("PROP: " + prop);
		if (prop.equals(null)) {
			throw new Exception("Profile variables could not be loaded");
		}
	}

	public class StepDefinitions {
		@Given("^a successful step$")
		public void aSuccessfulStep() throws Throwable {
			System.out.println("a successful step");
		}

		@Given("^a not successful step$")
		public void aNotSuccessfulStep() throws Throwable {
			System.out.println("a not successful step");
			Assert.fail();
		}
	}

}