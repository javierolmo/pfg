import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeuralnetworkComponent } from './neuralnetwork.component';

describe('NeuralnetworkComponent', () => {
  let component: NeuralnetworkComponent;
  let fixture: ComponentFixture<NeuralnetworkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeuralnetworkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeuralnetworkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
