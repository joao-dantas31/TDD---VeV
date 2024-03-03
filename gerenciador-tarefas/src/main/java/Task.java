import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
public class Task {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private Priority priority;

}
