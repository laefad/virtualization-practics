package part2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class Ticket {

    @Id
    long id;

    double price;

}
