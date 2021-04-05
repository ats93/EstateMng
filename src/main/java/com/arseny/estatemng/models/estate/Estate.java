package com.arseny.estatemng.models.estate;

import com.arseny.estatemng.models.*;
import com.arseny.estatemng.models.amenity.Amenity;
import com.arseny.estatemng.models.area.Area;
import com.arseny.estatemng.models.city.City;
import com.arseny.estatemng.models.type.TypeEstate;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estate_seq")
    @GenericGenerator(
            name = "estate_seq",
            strategy = "com.arseny.estatemng.models.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String cod;
    private String name;
    private Double originalPrice;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "cod")
    private TypeEstate type;
    private Boolean lowered;
    private String percentage;
    private String description;
    private Short bedrooms;
    private Short bathrooms;
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cod")
    private City city;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "area", referencedColumnName = "cod", insertable = false, updatable = false),
            @JoinColumn(name = "city", referencedColumnName = "city", insertable = false, updatable = false)})
    private Area area;
    @ManyToMany
    private List<Amenity> amenities;


}
