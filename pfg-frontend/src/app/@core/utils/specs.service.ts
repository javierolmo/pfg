import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {GeneticSpecs} from '../data/specs';
import {Sheet} from '../data/sheet';
import {Observable} from 'rxjs';
import {map} from "rxjs/operators";

@Injectable()
export class SpecsService {

    constructor(
        private httpClient: HttpClient,
    ) {

    }

    getRandomGeneticSpecs(requesterId: number): Observable<GeneticSpecs> {
        const urlRequest = `${environment.apiUrl}/api/specs/genetic-specs/random?requesterId=${requesterId}`;
        return this.httpClient.get<GeneticSpecs>(urlRequest).pipe(
            map(value => Object.assign(new GeneticSpecs(), value)),
        );
    }

    postGeneticSpecs(geneticSpecs: GeneticSpecs) {
        const urlRequest = `${environment.apiUrl}/api/specs/genetic-specs`;
        return this.httpClient.post<Sheet>(urlRequest, geneticSpecs);
    }

}
