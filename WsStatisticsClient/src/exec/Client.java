package exec;


import artifact.LoadStatistics;
import artifact.LoadStatisticsService;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadStatisticsService as = new LoadStatisticsService();
		LoadStatistics asp = as.getLoadStatisticsPort();
		String r = asp.loadStatistics();
		System.out.println(r);
	}

}