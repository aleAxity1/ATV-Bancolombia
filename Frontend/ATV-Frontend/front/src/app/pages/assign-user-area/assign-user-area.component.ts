import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatListOption, MatSelectionList } from '@angular/material/list';

@Component({
  selector: 'app-assign-user-area',
  standalone: true,
  imports: [
    MatSelectionList,
    MatListOption,
    MatButton,
    CommonModule,
    FormsModule
  ],
  templateUrl: './assign-user-area.component.html',
  styleUrl: './assign-user-area.component.scss'
})
export class AssignUserAreaComponent {
  items: string[] = ['Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5'];
  selectedItems: string[] = [];
  submittedItems: string[] = [];

  submitSelection(): void {
    this.submittedItems = [...this.selectedItems];
  }
}
