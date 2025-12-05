import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolverInicio } from './volver-inicio';

describe('VolverInicio', () => {
  let component: VolverInicio;
  let fixture: ComponentFixture<VolverInicio>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VolverInicio]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VolverInicio);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
