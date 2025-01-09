import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignUserProductComponent } from './assign-user-product.component';

describe('AssignUserProductComponent', () => {
  let component: AssignUserProductComponent;
  let fixture: ComponentFixture<AssignUserProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssignUserProductComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignUserProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
