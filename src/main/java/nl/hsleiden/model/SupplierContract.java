package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "supplier_contract")
public class SupplierContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractid", columnDefinition = "serial")
    @JsonView(View.Public.class)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplierid", nullable = false)
    @JsonBackReference("contractSupplierRef")
    private Supplier supplier;

    @NotNull
    @Column(name = "type_contract")
    @JsonProperty("type")
    @JsonView(View.Public.class)
    private String typeContract;

    @Length(max = 20)
    @Column(name = "contract_title")
    @JsonProperty("title")
    @JsonView(View.Public.class)
    private String title;

    @NotNull
    @Length(max = 100)
    @Column(name = "contract_description")
    @JsonProperty("description")
    @JsonView(View.Public.class)
    private String description;

    @NotNull
    @Column(name = "contract_inclu_btw")
    @JsonProperty("inclubtw")
    private double incluBtw;

    @NotNull
    @Column(name = "contract_excl")
    @JsonProperty("exclubtw")
    private double excluBtw;

    @Max(100)
    @Column(name = "contract_btw_percentage")
    @JsonProperty("btw_percentage")
    private double percentage;

    @Column(name = "contract_preconditions")
    @JsonProperty("pre_conditions")
    @JsonView(View.Public.class)
    private String preconditions;

    @Column(name = "contract_insurance")
    @JsonProperty("insurance")
    @JsonView(View.Public.class)
    private String insurance;

    @Column(name = "contract_responsibility")
    @JsonProperty("responsibility")
    @JsonView(View.Public.class)
    private String responsibility;

    @Column(name = "contract_extras")
    @JsonProperty("extras")
    @JsonView(View.Public.class)
    private String extras;

    @Column(name = "contract_start")
    @JsonProperty("startdate")
    private Date startDate;

    @Column(name = "contract_end")
    @JsonProperty("enddate")
    private Date endDate;


    public SupplierContract() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeContract() {
        return typeContract;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String isTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getIncluBtw() {
        return incluBtw;
    }

    public void setIncluBtw(double incluBtw) {
        this.incluBtw = incluBtw;
    }

    public double getExcluBtw() {
        return excluBtw;
    }

    public void setExcluBtw(double excluBtw) {
        this.excluBtw = excluBtw;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    @Override
    public boolean equals(Object object) {
        SupplierContract supplierContract = (SupplierContract) object;
        return (
                this.typeContract == supplierContract.isTypeContract() &&
                        this.title.equals(supplierContract.getTitle()) &&
                        this.description.equals(supplierContract.getDescription()) &&
                        this.incluBtw == supplierContract.getIncluBtw() &&
                        this.percentage == supplierContract.getPercentage() &&
                        this.preconditions.equals(supplierContract.getPreconditions()) &&
                        this.insurance.equals(supplierContract.getInsurance()) &&
                        this.responsibility.equals(supplierContract.getResponsibility()) &&
                        this.extras.equals(supplierContract.getExtras()) &&
                        this.endDate.equals(supplierContract.getEndDate()) &&
                        this.startDate.equals(supplierContract.getStartDate()) &&
                        this.id.equals(supplierContract.getId()) &&
                        this.typeContract.equals(supplierContract.getTypeContract())
        );
    }
}
