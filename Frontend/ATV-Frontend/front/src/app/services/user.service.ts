import { Injectable } from '@angular/core';
import { Endpoints } from 'src/environments/endpoints';
import { BasicUser, User } from '../model/http/user.model';
import { ConsumeService } from './consume.service';
import { Observable } from 'rxjs';
import { BranchByUser } from '../model/http/branchByUser.model';
import { ProductByUser } from '../model/http/productsByUser.model';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  constructor(private readonly consumeService: ConsumeService) { }

  getUsers(): Observable<User[]> {
    return this.consumeService.httpGet<User[]>(Endpoints.users.users);
  }
  getUserById(id: string): Observable<User> {
    return this.consumeService.httpGet<User>(`${Endpoints.users.users}/${id}`);
  }
  createUser(user: BasicUser): Observable<User> {
    return this.consumeService.httpPost<User>(`${Endpoints.users.users}`, user);
  }
  editUser(user: User): Observable<User> {
    return this.consumeService.httpPut<User>(
      `${Endpoints.users.users}/${user.xuuser}`,
      user
    );
  }
  deleteUser(id: string): Observable<void> {
    return this.consumeService.httpDelete<void>(
      `${Endpoints.users.users}/${id}`
    );
  }

  getBranchByUser(id: string): Observable<BranchByUser[]> {
    return this.consumeService.httpGet<BranchByUser[]>(`${Endpoints.users.userByBranch}/${id}`);
  }

  updateBranchByUser(id: string, branches: number[]): Observable<BranchByUser[]> {
    return this.consumeService.httpPut<BranchByUser[]>(
      `${Endpoints.users.userByBranch}/${id}`,
      branches
    );
  }

  getProductByUser(id: string): Observable<ProductByUser[]> {
    return this.consumeService.httpGet<ProductByUser[]>(`${Endpoints.users.usersByProduct}/${id}`);
  }

  updateProductByUser(id: string, product: string[]): Observable<ProductByUser[]> {
    return this.consumeService.httpPut<ProductByUser[]>(
      `${Endpoints.users.usersByProduct}/${id}`,
      product
    );
  }
}
