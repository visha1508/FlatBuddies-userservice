package com.find.flat_buddies.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.find.flat_buddies.model.Occupancy.occupancy_Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PropertyDetails")
public class PropertyDetails {
	
	public enum property_Type{
        FLAT, ROW_HOUSE, PG, BUNGLOW
    };
    
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "property_id")
    private long propertyId;
    
    @Enumerated(EnumType.STRING)
    @Column
	private property_Type propertyType;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;
	
    @Column
	private String availableFlatThings;
	
    @Column
	private String extraInformation;
	
    @Column
	private int availabilities;
	
    @Column
	private String aminities;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
	private List<Occupancy> occupancies;
    
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)  // Make sure this column exists in DB
    @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
    private User user;
    
    
}
