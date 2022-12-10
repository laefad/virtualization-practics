package part2.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import part2.model.Ticket;

@Repository
public interface TicketRepository extends ReactiveCrudRepository<Ticket, Long>{
    
}
