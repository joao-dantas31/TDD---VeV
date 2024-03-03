import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager manager;

    @BeforeEach
    void setup() {
        manager = new TaskManagerImp();
    }

    @Test
    public void testManagerInit() {
        assertTrue(manager.isEmpty());
        assertEquals(0, manager.size());
    }

    @Test
    @DisplayName("Testa se o gerenciador consegue criar uma tarefa.")
    void testCreate() {
        manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(), Priority.LOW);

        assertFalse(manager.isEmpty());
    }

    @Test
    @DisplayName("Testa se o gerenciador consegue criar multiplas tarefas.")
    void testMultipleCreate() {
        manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);
        manager.create("Tarefa 2", "Descrição da tarefa 2", new Date(1356609600000L), Priority.MEDIUM);
        manager.create("Tarefa 3", "Descrição da tarefa 3", new Date(196327953000L), Priority.HIGH);

        List<Task> tasks = manager.getAll();

        assertEquals(3, tasks.size());

        assertTrue(tasks.stream().anyMatch(task -> task.getTitle().equals("Tarefa 1") && task.getDescription().equals("Descrição da tarefa 1") && task.getDueDate().equals(new Date(999216000000L)) && task.getPriority().equals(Priority.LOW)));
        assertTrue(tasks.stream().anyMatch(task -> task.getTitle().equals("Tarefa 2") && task.getDescription().equals("Descrição da tarefa 2") && task.getDueDate().equals(new Date(1356609600000L)) && task.getPriority().equals(Priority.MEDIUM)));
        assertTrue(tasks.stream().anyMatch(task -> task.getTitle().equals("Tarefa 3") && task.getDescription().equals("Descrição da tarefa 3") && task.getDueDate().equals(new Date(196327953000L)) && task.getPriority().equals(Priority.HIGH)));
    }

    @Test
    @DisplayName("Testa se o gerenciador falha ao adicionar dados nulos.")
    void testNullCreate() {
        assertThrows(NullPointerException.class , () -> manager.create(null, "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW));
        assertThrows(NullPointerException.class , () -> manager.create("Tarefa 1", null, new Date(999216000000L), Priority.LOW));
        assertThrows(NullPointerException.class , () -> manager.create("Tarefa 1", "Descrição da tarefa 1", null, Priority.LOW));
        assertThrows(NullPointerException.class , () -> manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), null));
    }

    @Test
    @DisplayName("Testa se o gerenciador consegue atualizar os dados.")
    void testUpdate() {
        Task task = manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);

        Task updatedTask = manager.update(task.getId(), "Tarefa 3", null, null, null);

        assertEquals("Tarefa 3", updatedTask.getTitle());

        updatedTask = manager.update(task.getId(), null, "Descrição da tarefa 3", null, null);

        assertEquals("Descrição da tarefa 3", updatedTask.getDescription());

        updatedTask = manager.update(task.getId(), null, null, new Date(196327953000L), null);

        assertEquals(new Date(196327953000L), updatedTask.getDueDate());

        updatedTask = manager.update(task.getId(), null, null, null, Priority.HIGH);

        assertEquals(Priority.HIGH, updatedTask.getPriority());

        assertEquals(1, manager.size());
        Task finalTask = manager.getAll().get(0);

        assertEquals(new Task(task.getId(), "Tarefa 3", "Descrição da tarefa 3", new Date(196327953000L), Priority.HIGH), finalTask);
    }

    @Test
    @DisplayName("Testa se o gerenciador falha ao não atualizar nenhum dado.")
    void testNullUpdate() {
        Task task = manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);

        Task updatedTask = manager.update(task.getId(), null, null, null, null);

        assertEquals(task, updatedTask);
    }

    @Test
    @DisplayName("Testa se o gerenciador lança exceção ao tentar atualizar uma tarefa invalida.")
    void testNotFoundUpdate() {
        assertThrows(NoSuchElementException.class, () -> manager.update(1111L, null, null, null, null));
    }

    @Test
    @DisplayName("Testa se o gerenciador retorna valores corretos.")
    void testGet() {
        Task task = manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);

        assertEquals(1, manager.size());

        assertEquals(task, manager.getAll().get(0));
    }

    @Test
    @DisplayName("Testa se o gerenciador ordena os dados por prioridade e data.")
    void testPriorityGet() {
        manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);
        manager.create("Tarefa 2", "Descrição da tarefa 2", new Date(1356609600000L), Priority.MEDIUM);
        manager.create("Tarefa 3", "Descrição da tarefa 3", new Date(196327953000L), Priority.HIGH);
        manager.create("Tarefa 4", "Descrição da tarefa 4", new Date(999206000000L), Priority.LOW);
        manager.create("Tarefa 5", "Descrição da tarefa 5", new Date(1356709600000L), Priority.MEDIUM);
        manager.create("Tarefa 6", "Descrição da tarefa 6", new Date(186327953000L), Priority.HIGH);

        assertEquals(6, manager.size());

        List<Task> tasks = manager.getAll();

        assertEquals(manager.size(), tasks.size());

        assertEquals("Tarefa 6", tasks.get(0).getTitle());
        assertEquals("Tarefa 3", tasks.get(1).getTitle());
        assertEquals("Tarefa 2", tasks.get(2).getTitle());
        assertEquals("Tarefa 5", tasks.get(3).getTitle());
        assertEquals("Tarefa 4", tasks.get(4).getTitle());
        assertEquals("Tarefa 1", tasks.get(5).getTitle());
    }

    @Test
    @DisplayName("Testa se o gerenciador apaga tarefas corretamente.")
    void testDelete() {
        manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);
        Task toDelete = manager.create("Tarefa 2", "Descrição da tarefa 2", new Date(1356609600000L), Priority.MEDIUM);
        manager.create("Tarefa 3", "Descrição da tarefa 3", new Date(196327953000L), Priority.HIGH);

        assertEquals(3, manager.size());

        assertTrue(manager.delete(toDelete.getId()));

        assertEquals(2, manager.size());

        assertFalse(manager.getAll().stream().anyMatch(task -> task.getTitle().equals("Tarefa 2") && task.getDescription().equals("Descrição da tarefa 2") && task.getDueDate().equals(new Date(1356609600000L)) && task.getPriority().equals(Priority.MEDIUM)));
    }

    @Test
    @DisplayName("Testa se o gerenciador retorna falso ao apagar uma tarefa inexistente.")
    void testNotFoundDelete() {
        assertFalse(manager.delete(1111L));
    }

    @Test
    @DisplayName("Testa se o gerenciador consegue alterar prioridade de uma tarefa.")
    void testPriorityChange() {
        Task task = manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);

        assertEquals(Priority.HIGH, manager.changePriority(task.getId(), Priority.HIGH).getPriority());
    }

    @Test
    @DisplayName("Testa se o gerenciador lança uma exceção ao tentar definir uma prioridade nula.")
    void testNullPriorityChange() {
        Task task = manager.create("Tarefa 1", "Descrição da tarefa 1", new Date(999216000000L), Priority.LOW);

        assertThrows(NullPointerException.class, () -> manager.changePriority(task.getId(), null));
    }

    @Test
    @DisplayName("Testa se o gerenciador lança exceção ao tentar definir uma prioridade de uma tarefa invalida.")
    void testNotFoundPriorityChange() {
        assertThrows(NoSuchElementException.class, () -> manager.changePriority(1111L, Priority.LOW));
    }

}
