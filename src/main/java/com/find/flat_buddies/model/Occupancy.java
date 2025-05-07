package com.find.flat_buddies.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OccupancyDetails")
public class Occupancy {

	public enum occupancy_Type {
    	MASTER_BEDROOM, NON_MASTER_BEDROOM, HALL, MASTER_SHARING, NON_MASTER_SHARING, OTHER
    };

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "occupancy_id")
    private long occupancyId;
    
    @Column
    private String propertyRoomType; //1rk, 1bhk etc
    
    @Enumerated(EnumType.STRING)
    @Column
	private occupancy_Type occupancyType;
	
	@Column
	private double rent;
	
	@Column
	private double deposit;
	
	@Column
	private double otherExpenses;
	
	@Column
	private String availableRoomFurniture;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	private PropertyDetails property;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "occupancy_id", referencedColumnName = "occupancy_id")
	private List<Images> images;
	
}
