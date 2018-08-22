package utils;

public class Utility {

	private static Utility utils = new Utility();

	private Utility() {

	}

	public static Utility getInstance() {
		return utils;
	}

	public void waitFor(int durationInSeconds) {
		try {
			Thread.sleep(durationInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

}
