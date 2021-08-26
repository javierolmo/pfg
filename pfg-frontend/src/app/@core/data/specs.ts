import { Instrumento } from './instrumento';
import {Tonality} from './tonality';
import {Measure} from './measure';
import {Figura} from './figura';
import {UtilMethods} from './util-methods';

export class GeneticSpecs {

    requesterId: number;
    movementTitle: string;
    movementNumber: string;
    authors: string[];
    measures: number;
    compas: Measure;
    instrumentos: Instrumento[];
    tonalidad: Tonality;
    phraseLength: number;
    minFigura: Figura;
    maxFigura: Figura;

    constructor() {
        this.authors = [];
        this.instrumentos = [];
    }

    /**
     * Checks if the specs are valid for sending to backend.
     *
     * @return a description of the error if is not valid. Otherwise returns undefined
     */
    validate(): string {

        // Movement title
        if (this.movementTitle === undefined) return 'El título no debe estar vacío';
        if (this.movementTitle.length < 3) return 'El título debe tener al menos 3 caracteres';
        if (this.movementTitle.length > 255) return 'El título no debe tener más de 255 caracteres';

        // Measures
        if (this.measures === undefined) return 'El número de compases es obligatorio';
        if (this.measures > 300) return 'El número de compases no debe exceder de 300';
        if (this.measures < 30) return 'El número de compases no debe ser inferior a 30';

        return undefined;
    }

    randomize() {
        this.movementTitle = UtilMethods.randomTitle();
        this.movementNumber = '1';
        this.authors = ['Melodía'];
        this.measures = 30 + Math.floor(Math.random() * (300 - 30));
    }
}
