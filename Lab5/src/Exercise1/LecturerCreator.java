package Exercise1;

public class LecturerCreator implements IWorkerCreator {
    public AWorker create() {
        return new WorkerLecturer();
    }
}
