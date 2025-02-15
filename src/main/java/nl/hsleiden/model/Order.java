package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonView(View.Public.class)
    private Customer customer;

    @Column(name = "dateorder")
    @JsonProperty("dateorder")
    @JsonView(View.Public.class)
    private Date dateOrder;

    @Column(name = "dateevent")
    @JsonProperty("dateevent")
    @JsonView(View.Public.class)
    private Date dateEvent;

    @Column(name = "note")
    @JsonProperty("note")
    @JsonView(View.Public.class)
    private String note;

    @Column(name = "starttime")
    @JsonProperty("startTime")
    @JsonView(View.Public.class)
    private String startTime;

    @Column(name = "endtime")
    @JsonProperty("endTime")
    @JsonView(View.Public.class)
    private String endTime;

    @Column(name = "persons")
    @JsonProperty("persons")
    @JsonView(View.Public.class)
    private Long persons;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonProperty("cateringOrders")
    @JsonView(View.Public.class)
    private Set<CateringOrder> cateringOrders;

    @OneToOne
    @JoinColumn(name = "eventid")
    @JsonView(View.Public.class)
    private Event event;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonProperty("quotations")
    @JsonView(View.Public.class)
    private Set<Quotation> quotations;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonProperty("registeredEvents")
    @JsonView(View.Public.class)
    private Set<RegisteredEvent> registeredEvents;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPersons(long persons) {
        this.persons = persons;
    }
    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getPersons() { return persons; }

    public void setPersons(Long persons) { this.persons = persons; }

    public Set<CateringOrder> getCateringOrders() {
        return cateringOrders;
    }

    public void setCateringOrders(Set<CateringOrder> cateringOrders) {
        this.cateringOrders = cateringOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Set<Quotation> quotations) {
        this.quotations = quotations;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
