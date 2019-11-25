package eu.purplestudio.example.hibernate.persistance.integration.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mikolaj
 */
@Entity
@Table(name = "example")
public class ExampleEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "example_column")
    private String exampleColumn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExampleColumn() {
        return exampleColumn;
    }

    public void setExampleColumn(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }
      
}
