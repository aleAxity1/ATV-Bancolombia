import { Injectable } from '@angular/core';
import { ConsumeService } from './consume.service';
import { Endpoints } from 'src/environments/endpoints';
import { Domain } from '../model/http/domain.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DomainService {

  constructor(private readonly consumeService: ConsumeService) { }

  getDomains(): Observable<Domain[]> {
    return this.consumeService.httpGet<Domain[]>(Endpoints.domains.domains);
  }
}
