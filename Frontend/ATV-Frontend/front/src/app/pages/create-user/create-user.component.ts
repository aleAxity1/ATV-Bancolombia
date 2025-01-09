import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BasicUser } from 'src/app/model/http/user.model';
import { DataService } from 'src/app/services/data.service';
import { UsersService } from 'src/app/services/user.service';
import { UsersFormComponent } from '../../components/users-form/users-form.component';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss'],
  standalone: true,
  imports: [UsersFormComponent],
})
export class CreateUserComponent {
  constructor(
    private readonly userService: UsersService,
    private readonly dataService: DataService,
    private readonly router: Router,
  ) { }

  createUser(user: BasicUser): void {
    this.userService.createUser(user).subscribe({
      next: (response) => {
        if (response) {
          this.dataService.setGeneralNotificationMessage(`Alta Exitosa`);
        }

        this.router.navigate(['users']);
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    });
  }
}
