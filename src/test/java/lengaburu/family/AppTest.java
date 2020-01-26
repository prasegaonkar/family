package lengaburu.family;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private App app = null;

	@Before
	public void setup() {
		app = new App();
	}

	@Test
	public void test() throws FileNotFoundException, IOException, URISyntaxException {
		testx("input1.txt", "output1.txt");
		testx("input2.txt", "output2.txt");
		testx("input3.txt", "output3.txt");
		testx("input4.txt", "output4.txt");
		testx("input5.txt", "output5.txt");
		testx("input6.txt", "output6.txt");
	}

	private void testx(String input, String output) throws IOException, FileNotFoundException, URISyntaxException {
		final String inputFilePath = Paths
				.get(Thread.currentThread().getContextClassLoader().getResource(input).toURI()).toString();
		final String expectedOutputFilePath = Paths
				.get(Thread.currentThread().getContextClassLoader().getResource(output).toURI()).toString();
		File tempFile = Files.createTempFile(UUID.randomUUID().toString(), ".txt").toFile();
		final String actualOutputFilePath = tempFile.getAbsolutePath();
		FileOutputStream fos = new FileOutputStream(tempFile);
		app.processFile(inputFilePath, fos);
		fos.close();

		List<String> expectedOutput = Files.readAllLines(Paths.get(expectedOutputFilePath));
		List<String> actualOutput = Files.readAllLines(Paths.get(actualOutputFilePath));
		assertThat(actualOutput).containsExactlyElementsOf(expectedOutput);
	}
}
