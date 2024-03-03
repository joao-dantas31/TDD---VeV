import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

public class TaskManagerImp implements TaskManager{

    @Override
    public Task create(String title, String description, Date dueDate, Priority priority) {
        return null;
    }

    @Override
    public Task update(Long id, @Nullable String title, @Nullable String description, @Nullable Date dueDate, @Nullable Priority priority) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task changePriority(Long id, Priority priority) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
