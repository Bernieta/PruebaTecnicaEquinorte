import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MeasurementIndicator } from '../model/measurement.indicator';
import { MeasurementCreate } from '../model/measurement.create';

/**
 * Servicio de medidas
 */
@Injectable({
  providedIn: 'root',
})
export class MeasurementService {
  private readonly apiUrl = 'http://localhost:8080/api/measurements';

  constructor(private readonly http: HttpClient) {}

  /**
   * Obtiene las mediciones asociadas a un indicador por su id.
   * @param id - El identificador único del indicador.
   * @returns Observable<MeasurementIndicator[]> - Una lista de mediciones con estado.
   */
  public getMeasurementsWithStatusByIndicatorId(
    id: number
  ): Observable<MeasurementIndicator[]> {
    return this.http.get<MeasurementIndicator[]>(`${this.apiUrl}/${id}`);
  }

  /**
   * Crea una nueva medición.
   * @param newMeasurement - El objeto de medición a crear.
   * @returns Observable<MeasurementCreate> - La medición creada.
   */
  public createMeasurement(
    newMeasurement: MeasurementCreate
  ): Observable<MeasurementCreate> {
    return this.http.post<MeasurementCreate>(this.apiUrl, newMeasurement);
  }
}
