import { Injectable } from '@angular/core';
import { ConsumeService } from './consume.service';
import { Observable } from 'rxjs';
import { Access } from '../model/http/access.model';
import { Endpoints } from 'src/environments/endpoints';

@Injectable({
  providedIn: 'root',
})
export class AccessService {

  constructor(private readonly consumeService: ConsumeService) { }

  getAccess(): Observable<Access[]> {
    return this.consumeService.httpGet<Access[]>(Endpoints.access.access);
  }
}
