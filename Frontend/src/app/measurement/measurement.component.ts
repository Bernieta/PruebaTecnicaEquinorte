import { Component, OnInit } from '@angular/core';
import { MeasurementService } from '../service/measurement.service';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { MeasurementIndicator } from '../model/measurement.indicator';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

/**
 * Componente de medidad
 */
@Component({
  selector: 'app-measurement',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, RouterModule],
  templateUrl: './measurement.component.html',
  styleUrl: './measurement.component.css',
})
export class MeasurementComponent implements OnInit {
  measurementsIndicator: MeasurementIndicator[] = [];
  formMeasurement!: FormGroup;
  indicatorId!: string;

  constructor(
    private readonly measurementService: MeasurementService,
    private readonly activatedRoute: ActivatedRoute,
    private readonly formBuilder: FormBuilder
  ) {
    this.formMeasurement = this.formBuilder.group({
      indicatorId: [null, Validators.required],
      description: ['', Validators.required],
      measurementDate: ['', Validators.required],
      measurementValue: [0, [Validators.required, Validators.min(0)]],
    });
  }

  ngOnInit(): void {
    this.indicatorId =
      this.activatedRoute.snapshot.paramMap.get('indicatorId')!;
    if (this.indicatorId) {
      this.formMeasurement.patchValue({
        indicatorId: Number(this.indicatorId),
      });
      this.getMeasurementsWithStatusByIndicatorId(Number(this.indicatorId));
    }
  }

  /**
   * Obtiene las mediciones asociadas a un indicador por su id
   * y actualiza la lista de mediciones.
   * @param indicatorId - El identificador único del indicador.
   */
  public getMeasurementsWithStatusByIndicatorId(indicatorId: number) {
    this.measurementService
      .getMeasurementsWithStatusByIndicatorId(indicatorId)
      .subscribe((data) => {
        this.measurementsIndicator = data;
      });
  }

  /**
   * Crea una nueva medición utilizando los valores del formulario.
   * Muestra un mensaje de éxito o error según el resultado de la operación
   * y actualiza la lista de mediciones del indicador correspondiente.
   */
  public createMeasurement() {
    if (this.formMeasurement.invalid) {
      alert('Revise los campos e intente nuevamente');
      return;
    }
    this.measurementService
      .createMeasurement(this.formMeasurement.value)
      .subscribe({
        next: () => {
          alert('Medida creada exitosamente');
          this.getMeasurementsWithStatusByIndicatorId(Number(this.indicatorId));
        },
        error: () => {
          alert('No fue posible crear la medida');
        },
      });
  }
}
