import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatListOption, MatSelectionList } from '@angular/material/list';
import { Product } from 'src/app/model/http/product.model';
import { DataService } from 'src/app/services/data.service';
import { ProductService } from 'src/app/services/product.service';

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

  constructor(
    private readonly productService: ProductService,
    private readonly dataService: DataService,
  ) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe({
      next: (response) => {
        this.products = response;
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    })
  }

  submitSelection(): void {
    this.submittedItems = [...this.selectedItems];
  }
}
