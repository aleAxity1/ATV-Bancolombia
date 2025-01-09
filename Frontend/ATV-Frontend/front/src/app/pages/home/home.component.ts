import { Component, OnInit } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { RouterLink } from '@angular/router';
import { MatButton } from '@angular/material/button';
import { AppInitService } from '../../services/app-init.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  standalone: true,
  imports: [MatButton, RouterLink, TranslateModule],
})
export class HomeComponent implements OnInit{

  constructor(
    private readonly initService: AppInitService,
    private readonly dataService: DataService,
  ) { }

  ngOnInit(): void {
    this.initService.loadInitialData().subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (error) => this.dataService.setGeneralNotificationMessage(error),
    })
  }

}
