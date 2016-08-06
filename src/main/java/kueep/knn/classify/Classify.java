package kueep.knn.classify;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Classify {

	public static String classify() throws Exception{
		String predString = null;
		DataSource source = new DataSource("/Users/martinsaad/Desktop/projects/java/knn/src/main/java/resources/training.arff");
		Instances trainingDataSet = source.getDataSet();

		trainingDataSet.setClassIndex(trainingDataSet.numAttributes()-1);
		int numClasses = trainingDataSet.numClasses();
		for(int i = 0; i < numClasses; i++){
			String classValue = trainingDataSet.classAttribute().value(i);
			//System.out.println("Class value " + i + " is " + classValue);
		}

		IBk ibk = new IBk();
		ibk.buildClassifier(trainingDataSet);

		DataSource source1 = new DataSource("/Users/martinsaad/Desktop/projects/java/knn/src/main/java/resources/data.arff");
		Instances testDataSet = source1.getDataSet();
		testDataSet.setClassIndex(testDataSet.numAttributes()-1);

		for(int i = 0 ; i < testDataSet.numInstances(); i++){
			double actualClass = testDataSet.instance(i).classValue();
			String actual = testDataSet.classAttribute().value((int)actualClass);
			Instance newInst = testDataSet.instance(i);
			double predNB = ibk.classifyInstance(newInst);
			predString = testDataSet.classAttribute().value((int)predNB);
			//System.out.println(actual + ", " + predString);
		}
		return predString;
	}
}
