import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ConsumeService } from './consume.service';
import { Product } from '../model/http/product.model';
import { Endpoints } from 'src/environments/endpoints';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private readonly consumeService: ConsumeService) { }
  
    getProducts(): Observable<Product[]> {
      return this.consumeService.httpGet<Product[]>(Endpoints.product.products);
    }
}
