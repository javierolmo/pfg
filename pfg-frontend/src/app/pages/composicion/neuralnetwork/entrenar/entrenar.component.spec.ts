import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrenarComponent } from './entrenar.component';

describe('EntrenarComponent', () => {
  let component: EntrenarComponent;
  let fixture: ComponentFixture<EntrenarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrenarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrenarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
