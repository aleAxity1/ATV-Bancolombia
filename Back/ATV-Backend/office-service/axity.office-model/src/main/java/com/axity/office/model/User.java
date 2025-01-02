package bancolombia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATVFFUSR")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "XUUSER", length = 10, nullable = false)
    private String xuuser;

    @Column(name = "XUNAME", length = 60)
    private String xuname;

    @Column(name = "XUCARG", length = 6)
    private String xucarg;

    @Column(name = "XUACCE")
    private Short xuacce;

    @Column(name = "XUDOM", length = 2)
    private String xudom;

    @Column(name = "XUUSRT")
    private Short xuusrt;
}