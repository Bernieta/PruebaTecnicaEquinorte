import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Indicator } from '../model/indicator';

/**
 * Servicio del indicador
 */
@Injectable({
  providedIn: 'root',
})
export class IndicatorService {
  private readonly apiUrl = 'http://localhost:8080/api/indicators';

  constructor(private readonly http: HttpClient) {}

  /**
   * Obtiene todos los indicadores.
   * @returns Observable<Indicator[]> - Una lista de indicadores.
   */
  public getIndicators(): Observable<Indicator[]> {
    return this.http.get<Indicator[]>(this.apiUrl);
  }

  /**
   * Obtiene un indicador por su id.
   * @param id - El identificador único del indicador.
   * @returns Observable<Indicator> - El indicador correspondiente.
   */
  public getIndicatorById(id: number): Observable<Indicator> {
    return this.http.get<Indicator>(`${this.apiUrl}/${id}`);
  }

  /**
   * Crea un nuevo indicador.
   * @param newIndicator - El objeto indicador a crear.
   * @returns Observable<Indicator> - El indicador creado.
   */
  public createIndicator(newIndicator: Indicator): Observable<Indicator> {
    return this.http.post<Indicator>(this.apiUrl, newIndicator);
  }

  /**
   * Actualiza un indicador.
   * @param indicator - El objeto indicador con los datos actualizados.
   * @param id - El identificador único del indicador a actualizar.
   * @returns Observable<Indicator> - El indicador actualizado.
   */
  public updateIndicator(
    indicator: Indicator,
    id: number
  ): Observable<Indicator> {
    return this.http.put<Indicator>(`${this.apiUrl}/${id}`, indicator);
  }

  /**
   * Elimina un indicador por su ID.
   * @param id - El identificador único del indicador a eliminar.
   * @returns Observable<void> - Indica el resultado de la operación de eliminación.
   */
  public deleteIndicator(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
