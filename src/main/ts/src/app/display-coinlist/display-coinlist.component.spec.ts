import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayCoinlistComponent } from './display-coinlist.component';

describe('DisplayCoinlistComponent', () => {
  let component: DisplayCoinlistComponent;
  let fixture: ComponentFixture<DisplayCoinlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayCoinlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayCoinlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
