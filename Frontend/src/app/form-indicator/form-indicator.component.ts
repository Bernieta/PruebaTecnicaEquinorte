import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { IndicatorService } from '../service/indicator.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

/**
 * Componente del formulario para crear y actualizar indicadores
 */
@Component({
  selector: 'app-form-indicator',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, RouterModule],
  templateUrl: './form-indicator.component.html',
  styleUrl: './form-indicator.component.css',
})
export class FormIndicatorComponent implements OnInit {
  formIndicator!: FormGroup;
  isSaveProgress: boolean = false;
  edit: boolean = false;

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly indicatorService: IndicatorService,
    private readonly activatedRoute: ActivatedRoute,
    private readonly router: Router
  ) {
    this.formIndicator = this.formBuilder.group({
      indicatorName: ['', Validators.required],
      expectedValue: [0, [Validators.required, Validators.min(0)]],
      maxValue: [0, [Validators.required, Validators.min(0)]],
      minValue: [0, [Validators.required, Validators.min(0)]],
    });
  }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id !== 'new') {
      this.edit = true;
      this.getIndicatorById(Number(id));
    }
  }

  /**
   * Obtiene un indicador por su id y actualiza el formulario con sus valores.
   * @param id - El identificador único del indicador a recuperar.
   */
  public getIndicatorById(id: number) {
    this.indicatorService.getIndicatorById(id).subscribe({
      next: (indicator) => {
        this.formIndicator.patchValue(indicator);
      },
      error: () => {
        this.router.navigateByUrl('/');
      },
    });
  }

  /**
   * Crea un nuevo indicador utilizando los valores del formulario.
   * Muestra un mensaje de éxito o error según el resultado de la operación.
   */
  public createIndicator() {
    if (this.formIndicator.invalid) {
      alert('Revise los campos e intente nuevamente');
      return;
    }
    this.indicatorService.createIndicator(this.formIndicator.value).subscribe({
      next: () => {
        alert('Indicador creado exitosamente');
        this.router.navigateByUrl('/');
      },
      error: () => {
        alert('No fue posible realizar la operación');
        this.router.navigateByUrl('/');
      },
    });
  }

  /**
   * Actualiza un indicador existente utilizando los valores del formulario.
   * Muestra un mensaje de éxito o error según el resultado de la operación.
   */
  public updateIndicator() {
    if (this.formIndicator.invalid) {
      alert('Revise los campos e intente nuevamente');
      return;
    }
    let id = this.activatedRoute.snapshot.paramMap.get('id');
    this.indicatorService
      .updateIndicator(this.formIndicator.value, Number(id))
      .subscribe({
        next: () => {
          alert('Indicador actualizado exitosamente');
          this.router.navigateByUrl('/');
        },
        error: () => {
          alert('No fue posible realizar la operación');
          this.router.navigateByUrl('/');
        },
      });
  }
}
