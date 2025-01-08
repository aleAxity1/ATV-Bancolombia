export class BasicUser {
  xuuser: string; // IDENTIFICADOR DEL USUARIO
  xuname: string; // NOMBRE DE U
  xucarg: number; // CARGO DEL U
  xuarea: number; // AREA DEL USU
  xuacce: number; // ACCESO USUAR
  xudom: string; // DOMINIO USU
  xuusrt: number; // TIPO DE USU

  constructor() {
    this.xuuser = '';
    this.xuname = '';
    this.xucarg = 0;
    this.xuarea = 0;
    this.xuacce = 0;
    this.xudom = '';
    this.xuusrt = 0;
  }
}

export class User extends BasicUser {
  id: number;

  constructor() {
    super();
    this.id = 0;
  }
}
