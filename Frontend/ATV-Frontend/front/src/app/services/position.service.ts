import { Injectable } from '@angular/core';
import { ConsumeService } from './consume.service';
import { Observable } from 'rxjs';
import { Position } from '../model/http/position.model';
import { Endpoints } from 'src/environments/endpoints';

@Injectable({
  providedIn: 'root',
})
export class PositionService {

  constructor(private readonly consumeService: ConsumeService) { }

  getPositions(): Observable<Position[]> {
    return this.consumeService.httpGet<Position[]>(Endpoints.positions.positions);
  }
}
