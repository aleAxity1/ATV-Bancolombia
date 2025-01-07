import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LocalStorageService {
  // GUARDAR DATOS EN EL LOCAL STORAGE
  setItem<T>(key: string, value: T): void {
    localStorage.setItem(key, JSON.stringify(value));
  }

  // OBTENER DATOS DEL LOCAL STORAGE
  getItem<T>(key: string): T | null {
    const item = localStorage.getItem(key);
    return item ? JSON.parse(item) : null;
  }

  // ELIMINAR UN ELEMENTO DEL LOCAL STORAGE
  removeItem(key: string): void {
    localStorage.removeItem(key);
  }

  // LIMPIAR EL LOCAL STORAGE COMPLETO
  clear(): void {
    localStorage.clear();
  }
}
