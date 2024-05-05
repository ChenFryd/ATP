package Exercise1;

import java.util.HashMap;
import java.util.Map;

public class WorkerFactory {
    private Map<String, IWorkerCreator> workerCreator;
    public WorkerFactory(){
        workerCreator = new HashMap<>();
        initalizeWorkerCreators();
    }
    public AWorker createWorker(String type){
        if (workerCreator == null)
            throw new IllegalArgumentException("workerCreator not yet initialized");
        return workerCreator.get(type).create();
    }
    private void initalizeWorkerCreators(){
        workerCreator.put("lecturer", new LecturerCreator());
        workerCreator.put("admin", new AdminCreator());
        workerCreator.put("TA", new TACreator());
    }
}


