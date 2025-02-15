package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Robin Silverio
 */

@Entity
@Table(name = "registered_event")
public class RegisteredEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registeredeventid")
    @JsonView(View.Public.class)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "eventid", nullable = false)
    @JsonView(View.Public.class)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "instructorid", nullable = false)
    @JsonView(View.Public.class)
    private Instructor instructor;

    public RegisteredEvent(Order order, Event event, Instructor instructor) {
        this.order = order;
        this.event = event;
        this.instructor = instructor;
    }

    public RegisteredEvent() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
