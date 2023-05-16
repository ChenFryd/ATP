package Exercise1;

public class AdminCreator implements IWorkerCreator {
    public AWorker create() {
        return new WorkerAdmin();
    }
}
