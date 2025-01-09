export class BasicProduct {
    xpid: number;
    xpcopr: string;
    xpcodo: string;
    xpdsdo: string;
    xpcta: number;
    xpstdo: string;
    xpfeca: string;

    constructor() {
        this.xpid = 0;          // Long en Java se mapea como number en TypeScript
        this.xpcopr = '';       // String vacío
        this.xpcodo = '';       // String vacío
        this.xpdsdo = '';       // String vacío
        this.xpcta = 0;         // Long en Java se mapea como number en TypeScript
        this.xpstdo = '';       // String vacío
        this.xpfeca = '';       // String vacío
    }
}

export class Product extends BasicProduct {
    id: number;

    constructor() {
        super();
        this.id = 0;
    }
}