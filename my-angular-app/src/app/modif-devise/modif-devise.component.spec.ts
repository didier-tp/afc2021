import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifDeviseComponent } from './modif-devise.component';

describe('ModifDeviseComponent', () => {
  let component: ModifDeviseComponent;
  let fixture: ComponentFixture<ModifDeviseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifDeviseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifDeviseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
