package com.amitd.homeservicesandcleaningservicesportal.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    // @JsonIgnore
    // // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    // // property = "id", scope = Integer.class)
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch =
    // FetchType.LAZY)
    // private List<Work> works;

    // // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    // @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch =
    // FetchType.LAZY)
    // private List<Tag> tags;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    /**
     * @param name
     */
    public Category(String name) {
        this.name = name;
    }

}
