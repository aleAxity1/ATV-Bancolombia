package bancolombia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "XTCOD")
@Getter
@Setter
public class Position {

    @Id
    @Column(name = "XFAPCD", length = 255)
    private String xfapcd;

    @Column(name = "XFLDNM", length = 255)
    private String xfldnm;

    @Column(name = "XRELFL", length = 255)
    private String xrelfl;

    @Column(name = "XFMLCD", length = 255)
    private String xfmlcd;

    @Column(name = "XFENCD", length = 255)
    private String xfencd;

    @Column(name = "XFDFT", length = 255)
    private String xfdft;

    @Column(name = "XFDESC", length = 255)
    private String xfdesc;

    @Column(name = "XFLENG", length = 255)
    private String xfleng;

    @Column(name = "XFBLNK", length = 255)
    private String xfblnk;

    @Column(name = "XFSUSE", length = 255)
    private String xfsuse;

    @Column(name = "XFCORE", length = 255)
    private String xfcore;

    @Column(name = "XFENDT", length = 255)
    private String xfendt;

    @Column(name = "XFENTM", length = 255)
    private String xfentm;

    @Column(name = "XFSEDT", length = 255)
    private String xfsedt;

    @Column(name = "XFENUS", length = 255)
    private String xfenus;

    @Column(name = "XFENWS", length = 255)
    private String xfenws;

    @Column(name = "XFDTLM", length = 255)
    private String xfdtlm;

    @Column(name = "XFSDTM", length = 255)
    private String xfsdtm;
}