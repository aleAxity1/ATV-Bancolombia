import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignUserAreaComponent } from './assign-user-area.component';

describe('AssignUserAreaComponent', () => {
  let component: AssignUserAreaComponent;
  let fixture: ComponentFixture<AssignUserAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssignUserAreaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignUserAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
