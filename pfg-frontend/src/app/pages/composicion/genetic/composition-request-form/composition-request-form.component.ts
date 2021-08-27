import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { NbToastrService} from '@nebular/theme';
import { GeneticSpecs } from 'app/@core/data/specs';
import { Instrumento } from 'app/@core/data/instrumento';
import { UtilService } from 'app/@core/utils/util.service';
import {UserService} from '../../../../@core/utils/user.service';
import {Tonality} from '../../../../@core/data/tonality';
import {Measure} from '../../../../@core/data/measure';
import {InstrumentService} from '../../../../@core/utils/instrument.service';
import {TonalityService} from '../../../../@core/utils/tonality.service';
import {MeasureService} from '../../../../@core/utils/measure.service';
import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';
import {RestError} from '../../../../@core/data/error';
import {TokenPayload} from '../../../../@core/data/token';
import {SpecsService} from '../../../../@core/utils/specs.service';

@Component({
  selector: 'ngx-composition-request-form',
  templateUrl: './composition-request-form.component.html',
  styleUrls: ['./composition-request-form.component.scss'],
})
export class CompositionRequestFormComponent implements OnInit {

  // Select boxes content
  availableTonalities: Tonality[];
  availableMeasures: Measure[];
  availableInstruments: Instrumento[];

  // Specs
  specs: GeneticSpecs = new GeneticSpecs();

  constructor(
    private compositionService: UtilService,
    private formBuilder: FormBuilder,
    private toastrService: NbToastrService,
    private userService: UserService,
    private instrumentService: InstrumentService,
    private tonalityService: TonalityService,
    private measureService: MeasureService,
    private authService: NbAuthService,
    private specsService: SpecsService,
  ) {
    this.authService.onTokenChange().subscribe((token: NbAuthJWTToken) => {
      if (token.isValid()) {
        const payload: TokenPayload = token.getPayload();
        this.specs.requesterId = payload.id;
        this.specs.authors = [payload.name + ' ' + payload.surname];
      }
    });
  }

  ngOnInit(): void {
    this.instrumentService.getInstruments().subscribe(instruments => this.availableInstruments = instruments);
    this.measureService.getMeasures().subscribe(compases => this.availableMeasures = compases);
    this.tonalityService.getTonalities().subscribe(tonalidades => this.availableTonalities = tonalidades);
  }

  submit() {
    const error = this.specs.validate();
    if (error === undefined) {
      this.specsService.postGeneticSpecs(this.specs).subscribe(
          sheet => {
            this.toastrService.success(
                'Tu composición se ha puesto a la cola. Dentro de poco estará disponible',
                'SUCCESS!');
          },
          (response: RestError) => {
            this.toastrService.danger(response.error.message, 'ERROR');
          });
    } else {
      this.toastrService.warning(error, 'Formulario inválido');
    }
  }

  async randomize() {
    this.specsService.getRandomGeneticSpecs(this.specs.requesterId).subscribe(
        (specs: GeneticSpecs) => this.specs = specs,
        (response: RestError) => this.toastrService.danger(response.error.message, 'ERROR'),
    );
  }

}
