import { Component, OnInit } from '@angular/core';
import { Indicator } from '../model/indicator';
import { IndicatorService } from '../service/indicator.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

/**
 * Componente del indicador
 */
@Component({
  selector: 'app-indicator',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './indicator.component.html',
  styleUrl: './indicator.component.css',
})
export class IndicatorComponent implements OnInit {
  /**
   * Listado de los indicadores
   */
  indicators: Indicator[] = [];

  constructor(private readonly indicatorService: IndicatorService) {}

  ngOnInit(): void {
    this.getAllIndicators();
  }

  /**
   * Obtiene todos los indicadores y los asigna a la variable local `indicators`.
   * Suscribe a la respuesta del servicio para actualizar la lista de indicadores.
   */
  public getAllIndicators() {
    this.indicatorService.getIndicators().subscribe((data) => {
      this.indicators = data;
    });
  }

  /**
   * Elimina un indicador por su id después de confirmar la acción del usuario.
   * @param id - El identificador único del indicador a eliminar.
   */
  public deleteIndicator(id: number) {
    if (!confirm('¿Esta seguro de realizar esta acción?')) return;

    this.indicatorService.deleteIndicator(id).subscribe({
      next: () => {
        alert('Indicador eliminado exitosamente');
        this.getAllIndicators();
      },
      error: () => {
        alert('No fue posible eliminar el indicador');
      },
    });
  }
}
