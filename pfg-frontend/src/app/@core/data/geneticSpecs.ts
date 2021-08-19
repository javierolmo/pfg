import { Instrumento } from './instrumento';
import {Tonality} from './tonality';

export interface GeneticSpecs {
    movementTitle: string;
    movementNumber: string;
    measures: number;
    instrumentos: Instrumento[];
    authors: string[];
    compas: string;
    tonalidad: Tonality;
}
