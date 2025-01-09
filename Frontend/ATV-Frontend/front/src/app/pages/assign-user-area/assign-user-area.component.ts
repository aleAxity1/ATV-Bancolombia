import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatListOption, MatSelectionList } from '@angular/material/list';
import { BranchService } from '../../services/branch.service';
import { Branch } from 'src/app/model/http/branch.model';
import { UsersService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

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
export class AssignUserAreaComponent implements OnInit {
  branches: Branch[] = [];
  selectedItems: string[] = [];
  submittedItems: number[] = [];
  idUser = '';

  constructor(
    private readonly branchService: BranchService,
    private readonly UsersService: UsersService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    private readonly dataService: DataService,
  ) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {
      this.idUser = params.get('id') ?? '';
      this.getBranchesByUser(this.idUser);
    });

    this.branchService.getBranches().subscribe({
      next: (response) => {
        this.branches = response;
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    });
  }

  getBranchesByUser(id: string): void {
    this.UsersService.getBranchByUser(id).subscribe({
      next: (response) => {
        this.selectedItems = this.branches
        .filter(branch =>
          response.some(userBranch => userBranch.xscosu === Number(branch.xnnmky))
        )
        .map(branch => branch.xnnmky);
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    })
  }

  submitSelection(): void {
    this.submittedItems = this.selectedItems.map(item => parseInt(item));
    this.UsersService.updateBranchByUser(this.idUser, this.submittedItems).subscribe({
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
