package bancolombia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATVFFUSP")
@Getter
@Setter
public class ProductByUser {

    @Id
    @Column(name = "XPUSER", length = 10, nullable = false)
    private String xpuser;

    @Column(name = "XPCOPR", length = 2, nullable = false)
    private String xpcopr;
}