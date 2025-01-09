import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/http/user.model';
import { DataService } from 'src/app/services/data.service';
import { UsersService } from 'src/app/services/user.service';
import { TranslateModule } from '@ngx-translate/core';
import {
  MatTable,
  MatColumnDef,
  MatHeaderCellDef,
  MatHeaderCell,
  MatCellDef,
  MatCell,
  MatHeaderRowDef,
  MatHeaderRow,
  MatRowDef,
  MatRow,
} from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { MatButton } from '@angular/material/button';
import { MatIcon } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { LocalStorageService } from 'src/app/services/local-storage.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
  standalone: true,
  imports: [
    MatButton,
    RouterLink,
    MatTable,
    MatColumnDef,
    MatHeaderCellDef,
    MatHeaderCell,
    MatCellDef,
    MatCell,
    MatHeaderRowDef,
    MatHeaderRow,
    MatRowDef,
    MatRow,
    MatIcon,
    TranslateModule,
    CommonModule
  ],
})
export class UsersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'position', 'domain', 'accessLevel', 'actions'];
  data: User[] = [];
  constructor(
    private usersService: UsersService,
    private dataService: DataService,
    private localStorageService: LocalStorageService
  ) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    this.usersService.getUsers().subscribe({
      next: (users) => {
        this.data = users;
      },
      error: (err) => {
        this.dataService.setGeneralNotificationMessage(err);
      },
    });
  }

  deleteUser(id: string): void {
    this.usersService.deleteUser(id).subscribe({
      next: () => {
        this.data = this.data.filter((user) => user.xuuser !== id);
      },
      error: (err) => {
        this.dataService.setGeneralNotificationMessage(err);
      },
    });
  }

  getForeignName(
    tableKey: string,
    id: string,
    idKey: string,
    nameKey: string
  ): string {
    const table = JSON.parse(localStorage.getItem(tableKey) || '[]');
    const found = table.find((item: any) => item[idKey] === id);
    return found ? found[nameKey] : 'Desconocido';
  }
}
