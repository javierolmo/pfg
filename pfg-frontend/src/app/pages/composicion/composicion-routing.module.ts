import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ComposicionComponent} from './composicion.component';
import {NotFoundComponent} from '../miscellaneous/not-found/not-found.component';
import {GeneticComponent} from './genetic/genetic.component';
import {NeuralnetworkComponent} from './neuralnetwork/neuralnetwork.component';

const routes: Routes = [{
    path: '',
    component: ComposicionComponent,
    children: [
        {
            path: 'genetic',
            component: GeneticComponent,
        },
        {
            path: 'neural-network',
            component: NeuralnetworkComponent,
        },
        {
            path: '**',
            component: NotFoundComponent,
        },
    ],
}];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class ComposicionRoutingModule {
}
