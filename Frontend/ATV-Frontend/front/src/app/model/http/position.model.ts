export class BasicPosition {
    xfapcd: string;
    xfldnm: string;
    xrelfl: string;
    xfmlcd: string;
    xfencd: string;
    xfdft: string;
    xfdesc: string;
    xfleng: string;
    xfblnk: string;
    xfsuse: string;
    xfcore: string;
    xfendt: string;
    xfentm: string;
    xfsedt: string;
    xfenus: string;
    xfenws: string;
    xfdtlm: string;
    xfsdtm: string;

    constructor() {
        this.xfapcd = '';
        this.xfldnm = '';
        this.xrelfl = '';
        this.xfmlcd = '';
        this.xfencd = '';
        this.xfdft = '';
        this.xfdesc = '';
        this.xfleng = '';
        this.xfblnk = '';
        this.xfsuse = '';
        this.xfcore = '';
        this.xfendt = '';
        this.xfentm = '';
        this.xfsedt = '';
        this.xfenus = '';
        this.xfenws = '';
        this.xfdtlm = '';
        this.xfsdtm = '';
    }
}

export class Position extends BasicPosition {
    id: number;

    constructor() {
        super();
        this.id = 0;
    }
}