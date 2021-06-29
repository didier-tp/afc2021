import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCalculatriceComponent } from './my-calculatrice.component';

describe('MyCalculatriceComponent', () => {
  let component: MyCalculatriceComponent;
  let fixture: ComponentFixture<MyCalculatriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyCalculatriceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyCalculatriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
