export class BasicAccess {
    xaid: number;
    xaname: string;

    constructor() {
        this.xaid = 0;
        this.xaname = '';
    }
}

export class Access extends BasicAccess {
    id: number;

    constructor() {
        super();
        this.id = 0;
    }
}