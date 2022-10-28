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
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    // property = "id", scope = Integer.class)
    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // private Category category;

    // @JsonIgnore
    // @OneToOne(cascade = CascadeType.MERGE, mappedBy = "work", fetch =
    // FetchType.LAZY)
    // private Booking bookings;

    // @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "work", fetch =
    // FetchType.LAZY)
    // private List<Rating> ratings;

    // @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "work_progress", fetch =
    // FetchType.LAZY)
    // private List<WorkProgress> workProgresses;

    // @JsonIgnore
    // @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "works", fetch =
    // FetchType.LAZY)
    // private Set<User> users;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    /**
     * @param id
     */
    public Work(Integer id) {
        this.id = id;
    }

}
