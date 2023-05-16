package Exercise1;

public class TACreator implements IWorkerCreator {
    public AWorker create() {
        return new WorkerTA();
    }
}
