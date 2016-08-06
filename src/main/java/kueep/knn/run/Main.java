package kueep.knn.run;

import kueep.knn.classify.Classify;

public class Main {

	public static void main(String[] args) throws Exception {
		String classify = Classify.classify();
		System.out.println("classification is: " + classify);
	}

}
