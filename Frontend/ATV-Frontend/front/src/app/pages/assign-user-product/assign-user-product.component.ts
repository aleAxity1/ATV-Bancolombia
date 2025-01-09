import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatListOption, MatSelectionList } from '@angular/material/list';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/http/product.model';
import { DataService } from 'src/app/services/data.service';
import { ProductService } from 'src/app/services/product.service';
import { UsersService } from 'src/app/services/user.service';

@Component({
  selector: 'app-assign-user-product',
  standalone: true,
  imports: [
    MatSelectionList,
    MatListOption,
    MatButton,
    CommonModule,
    FormsModule
  ],
  templateUrl: './assign-user-product.component.html',
  styleUrl: './assign-user-product.component.scss'
})
export class AssignUserProductComponent implements OnInit {
  products: Product[] = [];
  selectedItems: string[] = [];
  submittedItems: string[] = [];
  idUser = '';

  constructor(
    private readonly productService: ProductService,
    private readonly UsersService: UsersService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    private readonly dataService: DataService,
  ) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {
      this.idUser = params.get('id') ?? '';
    });

    this.productService.getProducts().subscribe({
      next: (response) => {
        this.products = response;
        this.getProductByUser(this.idUser);
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    })
  }

  getProductByUser(id: string): void {
    this.UsersService.getProductByUser(id).subscribe({
      next: (response) => {
        this.selectedItems = this.products
        .filter(product =>
          response.some(userProduct => userProduct.xpcopr === product.xpcopr)
        )
        .map(product => product.xpcopr);
      },
      error: (error) => {
        this.dataService.setGeneralNotificationMessage(error);
      }
    })
  }

  submitSelection(): void {
    this.submittedItems = [...new Set(this.selectedItems)];

    this.UsersService.updateProductByUser(this.idUser, this.submittedItems).subscribe({
      next: (response) => {

        if (response) {
          this.dataService.setGeneralNotificationMessage(`Cambio Exitoso`);
        }

        this.router.navigate(['users']);
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    })
  }
}
