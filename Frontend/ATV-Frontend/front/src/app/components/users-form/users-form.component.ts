import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { BasicUser, User } from 'src/app/model/http/user.model';
import { MatButton } from '@angular/material/button';
import { CommonModule, NgIf } from '@angular/common';
import { MatInput } from '@angular/material/input';
import { MatFormField, MatLabel, MatError } from '@angular/material/form-field';
import { MatOption, MatSelect } from '@angular/material/select';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { Position } from 'src/app/model/http/position.model';
import { Access } from 'src/app/model/http/access.model';
import { Domain } from 'src/app/model/http/domain.model';

@Component({
  selector: 'app-users-form',
  templateUrl: './users-form.component.html',
  styleUrls: ['./users-form.component.scss'],
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatLabel,
    MatInput,
    MatSelect,
    MatOption,
    NgIf,
    MatError,
    MatButton,
    CommonModule
  ],
})
export class UsersFormComponent implements OnInit {

  @Input() user = new User();
  @Output() submitEmitter = new EventEmitter<BasicUser>();

  positions: Position [] = [];
  accesses: Access [] = [];
  domains: Domain [] = [];

  formGroup: FormGroup;
  constructor(
    private readonly fb: FormBuilder,
    private readonly localStorageService: LocalStorageService,
  ) {
    this.formGroup = this.fb.group({
      idUser: [
        '',
        Validators.compose(
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10)
          ]
        )
      ],
      name: [
        '',
        Validators.compose(
          [
            Validators.required,
            Validators.minLength(4),
            Validators.maxLength(30),
          ]
        )
      ],
      position: [
        '',
        Validators.compose(
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10)
          ]
        )
      ],
      domain: [
        '',
        Validators.compose(
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(2)
          ]
        )
      ],
      accessLevel: [
        '',
        Validators.compose(
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(2)
          ]
        )
      ],
    });
  }

  ngOnInit(): void {
    // SETEAR CATÁLOGOS CON LOCAL STORAGE
    this.setPositions();
    this.setAccess();
    this.setDomains();

    // SETEAR FORMULARIO DE USUARIO
    this.setFormGroup();
  }

  onSubmit(): void {
    const data = new User();

    data.xuuser = this.formGroup.get('idUser')?.value;
    data.xuname = this.formGroup.get('name')?.value;
    data.xucarg = this.formGroup.get('position')?.value;
    data.xuacce = parseInt(this.formGroup.get('accessLevel')?.value);
    data.xudom = this.formGroup.get('domain')?.value;

    this.submitEmitter.emit(data);
  }

  setFormGroup(): void {
    this.formGroup.get('idUser')?.setValue(this.user.xuuser);
    this.formGroup.get('name')?.setValue(this.user.xuname);
    this.formGroup.get('position')?.setValue(this.user.xucarg);
    this.formGroup.get('domain')?.setValue(this.user.xudom);
    this.formGroup.get('accessLevel')?.setValue(this.user.xuacce.toString());
  }

  setAccess(): void {
    const accesses: Access [] = this.localStorageService.getItem('access') ?? [];

    if(accesses) this.accesses = accesses;
  }

  setDomains(): void {
    const domains: Domain [] = this.localStorageService.getItem('domains') ?? [];

    if(domains) this.domains = domains;
  }

  setPositions(): void {
    const positions: Position [] = this.localStorageService.getItem('positions') ?? [];

    if(positions) this.positions = positions;
  }
}
