package bancolombia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATVFFUSA")
public class AccessByUser {

    @Id
    @Column(name = "XACOAC", nullable = false)
    private int xacoac;

    @Column(name = "XANAME", length = 60)
    private String xaname;

    // Getters and Setters
    public int getXacoac() {
        return xacoac;
    }

    public void setXacoac(int xacoac) {
        this.xacoac = xacoac;
    }

    public String getXaname() {
        return xaname;
    }

    public void setXaname(String xaname) {
        this.xaname = xaname;
    }
}