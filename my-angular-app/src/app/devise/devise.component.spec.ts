import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviseComponent } from './devise.component';

describe('DeviseComponent', () => {
  let component: DeviseComponent;
  let fixture: ComponentFixture<DeviseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeviseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeviseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
