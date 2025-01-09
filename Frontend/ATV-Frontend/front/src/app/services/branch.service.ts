import { Injectable } from '@angular/core';
import { ConsumeService } from './consume.service';
import { Observable } from 'rxjs';
import { Branch } from '../model/http/branch.model';
import { Endpoints } from 'src/environments/endpoints';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  constructor(private readonly consumeService: ConsumeService) { }

  getBranches(): Observable<Branch[]> {
    return this.consumeService.httpGet<Branch[]>(Endpoints.branch.branches);
  }
}
