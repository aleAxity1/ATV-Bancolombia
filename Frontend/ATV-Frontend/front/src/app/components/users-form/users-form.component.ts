import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { BasicUser, User } from 'src/app/model/http/user.model';
import { MatButton } from '@angular/material/button';
import { NgIf } from '@angular/common';
import { MatInput } from '@angular/material/input';
import { MatFormField, MatLabel, MatError } from '@angular/material/form-field';
import { MatOption, MatSelect } from '@angular/material/select';

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
  ],
})
export class UsersFormComponent implements OnInit {
  @Input() user = new User();
  @Output() submitEmitter = new EventEmitter<BasicUser>();
  formGroup: FormGroup;
  constructor(private fb: FormBuilder) {
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
            Validators.maxLength(2)
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
    //this.formGroup.get('idUser')?.setValue(this.user.id);
    this.formGroup.get('name')?.setValue(this.user.xuname);
    this.formGroup.get('position')?.setValue(this.user.xucarg);
    this.formGroup.get('domain')?.setValue(this.user.xudom);
    this.formGroup.get('accessLevel')?.setValue(this.user.xuacce);
    console.log(this.user)
  }

  onSubmit(): void {
    const data = new BasicUser();
    //data.id = this.formGroup.get('idUser')?.value;
    data.xuname = this.formGroup.get('name')?.value;
    data.xucarg = this.formGroup.get('position')?.value;
    data.xuacce = this.formGroup.get('accessLevel')?.value;
    data.xudom = this.formGroup.get('domain')?.value;
    this.submitEmitter.emit(data);
  }
}
