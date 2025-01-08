export class BasicDomain {
    xdid: string;
    xdname: string;

    constructor() {
        this.xdid = '';
        this.xdname = '';
    }
}

export class Domain extends BasicDomain {
    id: number;

    constructor() {
        super();
        this.id = 0;
    }
}