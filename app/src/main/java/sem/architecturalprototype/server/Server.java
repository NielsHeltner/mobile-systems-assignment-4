package sem.architecturalprototype.server;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sem.architecturalprototype.common.IDataPoint;
import sem.architecturalprototype.common.IServer;

public class Server implements IServer {

    private final List<IDataPoint> dataPoints;
    private IClassifier classifier;

    public Server() {
        dataPoints = new ArrayList<>();
    }

    @Override
    public boolean upload(IDataPoint dataPoint) {
        classifier.classify(dataPoint, dataPoints);

        dataPoints.add(dataPoint);

        return true;
    }

    /**
     * Method for dependency injection / late binding of a classifier
     * @param classifier an implementation of the IClassifier interface
     */
    @Inject
    public void setClassifier(IClassifier classifier) {
        this.classifier = classifier;
    }

}