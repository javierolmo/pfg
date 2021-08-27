import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComposicionRoutingModule } from './composicion-routing.module';
import { ComposicionComponent } from './composicion.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
    NbButtonModule,
    NbCardModule, NbIconModule,
    NbInputModule,
    NbSelectModule,
    NbTabsetModule,
    NbToastrModule,
} from '@nebular/theme';
import { CompositionRequestFormComponent } from './genetic/composition-request-form/composition-request-form.component';
import { UtilService } from 'app/@core/utils/util.service';
import {InstrumentService} from '../../@core/utils/instrument.service';
import {TonalityService} from '../../@core/utils/tonality.service';
import {MeasureService} from '../../@core/utils/measure.service';
import { GeneticComponent } from './genetic/genetic.component';
import { NeuralnetworkComponent } from './neuralnetwork/neuralnetwork.component';
import { IntroduccionComponent } from './neuralnetwork/introduccion/introduccion.component';
import { GenerarComponent } from './neuralnetwork/generar/generar.component';
import { EntrenarComponent } from './neuralnetwork/entrenar/entrenar.component';
import {SpecsService} from '../../@core/utils/specs.service';


@NgModule({
  declarations: [
      ComposicionComponent,
      CompositionRequestFormComponent,
      GeneticComponent,
      NeuralnetworkComponent,
      IntroduccionComponent,
      GenerarComponent,
      EntrenarComponent,
  ],
    imports: [
        CommonModule,
        ComposicionRoutingModule,
        ReactiveFormsModule,
        NbInputModule,
        NbSelectModule,
        NbButtonModule,
        NbCardModule,
        FormsModule,
        NbToastrModule,
        NbTabsetModule,
        NbIconModule,
    ],
  providers: [UtilService, InstrumentService, TonalityService, MeasureService, SpecsService],
})
export class ComposicionModule { }
