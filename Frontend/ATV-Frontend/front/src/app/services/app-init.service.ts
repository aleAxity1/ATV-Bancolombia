import { Injectable } from '@angular/core';
import { AccessService } from './access.service';
import { DomainService } from './domain.service';
import { PositionService } from './position.service';
import { LocalStorageService } from './local-storage.service';
import { forkJoin, Observable, of } from 'rxjs';
import { KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root',
})
export class AppInitService {
  constructor(
    private readonly accessService: AccessService,
    private readonly domainService: DomainService,
    private readonly positionService: PositionService,
    private readonly localStorageService: LocalStorageService,
    protected readonly keycloak: KeycloakService,
  ) { }

  loadInitialData(): Observable<void> {
    return new Observable<void>((observer) => {
      // Verificar si el usuario está autenticado de manera sincrónica usando `of()`
      of(this.keycloak.isLoggedIn()).subscribe({
        next: (isAuthenticated) => {
          if (isAuthenticated) {
            // Ejecutar forkJoin para obtener todos los datos
            forkJoin({
              access: this.accessService.getAccess(),
              domains: this.domainService.getDomains(),
              positions: this.positionService.getPositions(),
            }).subscribe({
              next: (data) => {
                // GUARDAR EN LOCAL STORAGE
                this.localStorageService.setItem('access', data.access);
                this.localStorageService.setItem('domains', data.domains);
                this.localStorageService.setItem('positions', data.positions);

                observer.complete(); // Completar el observable
              },
              error: (err) => {
                console.error('Error al cargar los datos iniciales:', err);
                observer.error(err); // Manejar errores
              },
            });
          } else {
            console.error('Usuario no autenticado');
            observer.error('Usuario no autenticado'); // Error si no está autenticado
          }
        },
        error: (err) => {
          console.error('Error al verificar autenticación de Keycloak', err);
          observer.error(err); // Error si no se pudo verificar autenticación
        },
      });
    });
  }
}

